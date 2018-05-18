package com.siaivo.bid.controller;

import com.siaivo.bid.model.Buyer;
import com.siaivo.bid.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class BuyerController {
    @Autowired
    private BuyerService buyerService;

    @RequestMapping(value="/sales/allBuyers", method = RequestMethod.GET)
    public ModelAndView allBuyers(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allBuyers", buyerService.listAllBuyers());
        modelAndView.setViewName("/sales/allBuyers");
        return modelAndView;
    }
    @RequestMapping(value="/sales/buyerRegistration", method = RequestMethod.GET)
    public ModelAndView buyerRegistration(){
        ModelAndView modelAndView = new ModelAndView();
        Buyer buyer = new Buyer();
        modelAndView.addObject("buyer", buyer);
        modelAndView.setViewName("/sales/buyerRegistration");
        return modelAndView;
    }

    @RequestMapping(value = "/sales/buyerRegistration", method = RequestMethod.POST)
    public ModelAndView createNewBuyer(@Valid Buyer buyer, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Buyer buyerExists = buyerService.findByName(buyer.getName());
                if (buyerExists != null) {
            bindingResult
                    .rejectValue("name", "error.buyer",
                            "Такий покупець вже зареєстрований");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("/sales/buyerRegistration");
        } else {
            buyerService.saveBuyer(buyer);
            modelAndView.addObject("successMessage", "Покупця успішно додано");
            modelAndView.addObject("buyer", new Buyer());
            modelAndView.setViewName("/sales/buyerRegistration");
        }
        return modelAndView;
    }
 }
