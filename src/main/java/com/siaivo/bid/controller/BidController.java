package com.siaivo.bid.controller;

import com.siaivo.bid.model.Bid;
import com.siaivo.bid.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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

      @RequestMapping(value = "/sales/bid", method = RequestMethod.GET)
    public ModelAndView createNewBidGet() {
        ModelAndView modelAndView = new ModelAndView();
        Bid bid = new Bid();
        modelAndView.addObject("bid", bid);
        modelAndView.addObject("listAllBuyers", buyerService.listAllBuyers());
        modelAndView.addObject("listAllProducts", productService.listAllProducts());
        return modelAndView;
    }

    @RequestMapping(value = "/sales/bid", method = RequestMethod.POST)
    public ModelAndView createNewBidPost(@Valid Bid bid, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
//        List<FieldError> errors = bindingResult.getFieldErrors();
//        for (FieldError error : errors ) {
//            System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
//        }
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("listAllProducts", productService.listAllProducts());
            modelAndView.addObject("listAllBuyers", buyerService.listAllBuyers());
            return modelAndView;
        } else {
            bidService.saveSalesBid(bid);
            modelAndView.addObject("successMessage", "Заявку успішно створено");
          //  modelAndView.addObject("listAllBuyers", buyerService.listAllBuyers());
          //  modelAndView.addObject("listAllProducts", productService.listAllProducts());
        //    modelAndView.addObject("bid", new Bid());
        }
        return new ModelAndView("redirect:/sales/inWorkBidsList");
    }

    @RequestMapping(value = {"sales/allBidsList", "purchase/allBidsList"}, method = RequestMethod.GET)
    public ModelAndView allBids() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allBidsList", bidService.allBidsList());
        // modelAndView.setViewName("sales/allBidsList");
        return modelAndView;
    }

    @RequestMapping(value = "sales/inWorkBidsList", method = RequestMethod.GET)
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
    @RequestMapping(value = "logist/logistBidsList", method = RequestMethod.GET)
    public ModelAndView logistBids() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("logistBidsList", bidService.logistBidsList());
        modelAndView.setViewName("logist/logistBidsList");
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

//      @RequestMapping(value = "/purchase/closeBid/{bidId}", method = RequestMethod.GET)
//        public ModelAndView purchaseCloseBid(@PathVariable(value = "bidId") int bidId ) {
//       ModelAndView modelAndView = new ModelAndView();
//        Bid bid = bidService.findBidByBidId(bidId);
//        modelAndView.addObject("bid", bid);
//        modelAndView.setViewName("/purchase/closeBid");
//        return modelAndView;
//      }
//
//    @RequestMapping(value = "/purchase/closeBid", method = RequestMethod.POST)
//    public ModelAndView purchaseCloseBid(@ModelAttribute("bid") Bid bid) {
//        ModelAndView modelAndView = new ModelAndView();
//        System.out.println(bid.getDestinationPlace()+" first");
//        modelAndView.addObject("successMessage", "Заявку успішно створено");
//        return modelAndView;
//    }

    @RequestMapping(value = "/purchase/closeBid/{bidId}", method = RequestMethod.GET)
    public ModelAndView closeBidPurchaseGet(@PathVariable(value = "bidId") int bidId){
        ModelAndView modelAndView = new ModelAndView();
        Bid bid =  bidService.findBidByBidId(bidId);
        modelAndView.addObject("bid", bid);
        modelAndView.setViewName("/purchase/closeBid");
        return modelAndView;
    }
    @RequestMapping(value = "/purchase/closeBid", method = RequestMethod.POST)
        public ModelAndView closeBidPurchasePost(@ModelAttribute ("bid") Bid bid) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("bidId "+bid.getBidId());

        try {
        int purchasePrice = bid.getPurchasePrice();
        String purchaseCountry = bid.getPurchaseCountry();
        String purchasePlace = bid.getPurchasePlace();
        int purchaseWeight = bid.getPurchaseWeight();
        String purchaseCurrency = bid.getPurchaseCurrency();
        Float purchaseAdmixture = bid.getPurchaseAdmixture();
        Float purchaseHumidity = bid.getPurchaseHumidity();
        String purchasePackingType = bid.getPurchasePackingType();
        String purchasePallets = bid.getPurchasePallets();
        bid = bidService.findBidByBidId(bid.getBidId());


            bid.setPurchasePrice (purchasePrice);
            bid.setPurchaseCountry (purchaseCountry);
            bid.setPurchasePlace (purchasePlace);
            bid.setPurchaseWeight (purchaseWeight);
            bid.setPurchaseCurrency (purchaseCurrency);
            bid.setPurchaseAdmixture (purchaseAdmixture);
            bid.setPurchaseHumidity (purchaseHumidity);
            bid.setPurchasePackingType (purchasePackingType);
            bid.setPurchasePallets (purchasePallets);
            bidService.savePurchaseBid(bid);
            }
            catch (Exception e){
                System.out.println("error alarm "+e);
                modelAndView.addObject("bid", bid);
                modelAndView.addObject("errorMessage", "Будь ласка, заповніть всі поля");
                return modelAndView;
            }
         return new ModelAndView("redirect:/purchase/purchaseBidsList");

    }
    @RequestMapping(value = "/logist/closeBid/{bidId}", method = RequestMethod.GET)
    public ModelAndView closeBidLogistGet(@PathVariable(value = "bidId") int bidId){
        ModelAndView modelAndView = new ModelAndView();
        Bid bid =  bidService.findBidByBidId(bidId);
        modelAndView.addObject("bid", bid);
        modelAndView.setViewName("/logist/closeBid");
        return modelAndView;
    }
    @RequestMapping(value = "/logist/closeBid", method = RequestMethod.POST)
    public ModelAndView closeBidLogistPost(@ModelAttribute ("bid") Bid bid) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("bidId "+bid.getBidId());
        int purchaseDeliveryCosts = bid.getPurchaseDeliveryCosts();
      //  int saleDeliveryCosts = bid.getSaleDeliveryCosts();

        try {
            bid.setPurchaseDeliveryCosts(purchaseDeliveryCosts);
       //     bid.setSaleDeliveryCosts(saleDeliveryCosts);
            bidService.saveLogistBid(bid);
        }
        catch (Exception e){
            System.out.println("error alarm "+e);
            return modelAndView;
        }
        modelAndView.addObject("successMessage", "Заявку успішно закрито");
        return modelAndView;
    }
}