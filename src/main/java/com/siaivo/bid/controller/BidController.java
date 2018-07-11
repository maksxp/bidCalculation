package com.siaivo.bid.controller;

import com.siaivo.bid.model.Bid;
import com.siaivo.bid.model.PurchaseData;
import com.siaivo.bid.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
public class BidController {

    @Autowired
    private BidService bidService;
    @Autowired
    private UserService userService;
    @Autowired
    private BuyerService buyerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private PurchaseDataService purchaseDataService;

    @RequestMapping(value = "/sales/bid", method = RequestMethod.GET)
    public ModelAndView createNewBid() {
        ModelAndView modelAndView = new ModelAndView();
        Bid bid = new Bid();
        modelAndView.addObject("bid", bid);
        modelAndView.addObject("listAllBuyers", buyerService.listAllBuyers());
        modelAndView.addObject("listAllProducts", productService.listAllProducts());
        return modelAndView;
    }

    @RequestMapping(value = "/sales/bid", method = RequestMethod.POST)
    public ModelAndView createNewBid(@Valid Bid bid, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
//        List<FieldError> errors = bindingResult.getFieldErrors();
//        for (FieldError error : errors ) {
//            System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
//        }
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("listAllProducts", productService.listAllProducts());
            modelAndView.addObject("listAllBuyers", buyerService.listAllBuyers());
        } else {
            bidService.saveSalesBid(bid);
            modelAndView.addObject("successMessage", "Заявку успішно створено");
            modelAndView.addObject("listAllBuyers", buyerService.listAllBuyers());
            modelAndView.addObject("listAllProducts", productService.listAllProducts());
            modelAndView.addObject("bid", new Bid());
        }
        return modelAndView;
    }

    @RequestMapping(value = {"sales/allBidsList", "purchase/allBidsList"}, method = RequestMethod.GET)
    public ModelAndView allBids() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allBidsList", bidService.allBidsList());
        // modelAndView.setViewName("sales/allBidsList");
        return modelAndView;
    }

    @RequestMapping(value = {"sales/inWorkBidsList", "purchase/inWorkBidsList"}, method = RequestMethod.GET)
    public ModelAndView InWorkBidsList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("inWorkBidsList", bidService.inWorkBidsList());
        //  modelAndView.setViewName("sales/inWorkBidsList");
        return modelAndView;
    }

    @RequestMapping(value = "sales/approvedBidsList", method = RequestMethod.GET)
    public ModelAndView salesApprovedBidsList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("approvedBidsList", bidService.approvedBidsList());
        modelAndView.setViewName("sales/approvedBidsList");
        return modelAndView;
    }

    @RequestMapping(value = "purchase/purchaseBidsList", method = RequestMethod.GET)
    public ModelAndView purchaseBids() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("purchaseBidsList", bidService.purchaseBidsList());
        modelAndView.setViewName("purchase/purchaseBidsList");
        return modelAndView;
    }

    @RequestMapping(value = "/sales/confirmBid/{bidId}", method = RequestMethod.GET)
    public ModelAndView confirmBid(@PathVariable(value = "bidId") int bidId) {
        Bid bid = bidService.findBidByBidId(bidId);
        bidService.confirmBid(bid);
        return new ModelAndView("redirect:/viasat/assignedBidsList");
    }

    @RequestMapping(value = "/sales/confirmBid", method = RequestMethod.POST)
    public ModelAndView confirmBid(@ModelAttribute("bid") Bid bid) {
        bidService.confirmBid(bid);
        return new ModelAndView("redirect:/viasat/allBidsLists");
    }

    @RequestMapping(value = "/purchase/editBid/{id}", method = RequestMethod.GET)
    public ModelAndView purchaseEditBid(@PathVariable(value = "id") int bidId) {
        ModelAndView modelAndView = new ModelAndView();
        Bid bid = bidService.findBidByBidId(bidId);
        modelAndView.addObject("bid", bid);
        modelAndView.setViewName("purchase/editBid");
        return modelAndView;
    }

    @RequestMapping(value = "/purchase/editBid", method = RequestMethod.POST)
    public ModelAndView purchaseEditBid(@ModelAttribute("bid") Bid bid) {
        ModelAndView modelAndView = new ModelAndView();
        int weight = bid.getWeightForSale();
        int bidId = bid.getBidId();
        bid = bidService.findBidByBidId(bidId);
        bidService.editBid(bid, weight);
        modelAndView.addObject("successMessage", "Заявку успішно закрито");
        return modelAndView;
    }

    @RequestMapping(value = "/purchase/closeBid/{id}", method = RequestMethod.GET)
    public ModelAndView purchaseCloseBid(@PathVariable(value = "id") int bidId) {
        ModelAndView modelAndView = new ModelAndView();
        Bid bid = bidService.findBidByBidId(bidId);
        PurchaseData purchaseData = new PurchaseData();
        modelAndView.addObject("bid", bid);
        modelAndView.addObject("purchaseData", purchaseData);
        modelAndView.setViewName("/purchase/closeBid");
        return modelAndView;
    }

    @RequestMapping(value = "/purchase/closeBid", method = RequestMethod.POST)
    public ModelAndView purchaseCloseBid(@ModelAttribute("bid") Bid bid, @Valid PurchaseData purchaseData, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
                List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError error : errors ) {
            System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
        }
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("bid", bid);
            modelAndView.addObject("purchaseData", purchaseData);
        } else {
           purchaseDataService.savePurchaseData(purchaseData);
           bidService.savePurchaseBid(bid);
        }
        return modelAndView;
    }
}