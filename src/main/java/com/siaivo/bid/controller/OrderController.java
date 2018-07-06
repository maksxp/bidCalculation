package com.siaivo.bid.controller;

import com.siaivo.bid.model.Order;
import com.siaivo.bid.model.User;
import com.siaivo.bid.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.siaivo.bid.service.*;

import javax.validation.Valid;


@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private BuyerService buyerService;
    @Autowired
    private ProductService productService;

    @RequestMapping(value= "/sales/order", method = RequestMethod.GET)
    public ModelAndView createNewOrder(){
        ModelAndView modelAndView = new ModelAndView();
        Order order = new Order ();
        modelAndView.addObject("order", order);
        modelAndView.addObject("listAllBuyers", buyerService.listAllBuyers());
        modelAndView.addObject("listAllProducts", productService.listAllProducts());
        return modelAndView;
    }
    @RequestMapping(value = "/sales/order", method = RequestMethod.POST)
    public ModelAndView createNewOrder(@Valid Order order, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
             modelAndView.addObject("listAllProducts", productService.listAllProducts());
            modelAndView.addObject("listAllBuyers", buyerService.listAllBuyers());
                   } else {
            orderService.saveSalesOrder(order);
            modelAndView.addObject("successMessage", "Заявку успішно створено");
            modelAndView.addObject("listAllBuyers", buyerService.listAllBuyers());
            modelAndView.addObject("listAllProducts", productService.listAllProducts());
            modelAndView.addObject("order", new Order());
           }
        return modelAndView;
    }

    @RequestMapping(value={"sales/allOrdersList", "purchase/allOrdersList"}, method = RequestMethod.GET)
    public ModelAndView allOrders(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allOrdersList", orderService.allOrdersList());
       // modelAndView.setViewName("sales/allOrdersList");
        return modelAndView;
    }
    @RequestMapping(value={"sales/inWorkOrdersList", "purchase/inWorkOrdersList"}, method = RequestMethod.GET)
     public ModelAndView InWorkOrdersList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("inWorkOrdersList", orderService.inWorkOrdersList());
      //  modelAndView.setViewName("sales/inWorkOrdersList");
        return modelAndView;
    }
    @RequestMapping(value="sales/approvedOrdersList", method = RequestMethod.GET)
    public ModelAndView salesApprovedOrdersList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("approvedOrdersList", orderService.approvedOrdersList());
        modelAndView.setViewName("sales/approvedOrdersList");
        return modelAndView;
    }

    @RequestMapping(value="purchase/purchaseOrdersList", method = RequestMethod.GET)
    public ModelAndView purchaseOrders(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("purchaseOrdersList", orderService.purchaseOrdersList());
        modelAndView.setViewName("purchase/purchaseOrdersList");
        return modelAndView;
    }

    @RequestMapping(value = "/sales/confirmOrder/{id}", method = RequestMethod.GET)
    public ModelAndView confirmOrder(@PathVariable(value = "id") int id){
        Order order =  orderService.findOrderById(id);
        orderService.confirmOrder(order);
        return new ModelAndView("redirect:/viasat/assignedOrdersList");
    }
    @RequestMapping(value = "/sales/confirmOrder", method = RequestMethod.POST)
    public ModelAndView confirmOrder (@ModelAttribute("order")Order order) {
        orderService.confirmOrder(order);
        return new ModelAndView("redirect:/viasat/allOrdersLists");
    }
    @RequestMapping(value = "/purchase/editOrder/{id}", method = RequestMethod.GET)
    public ModelAndView editOrder(@PathVariable(value = "id") int id){
        ModelAndView modelAndView = new ModelAndView();
        Order order =  orderService.findOrderById(id);
        modelAndView.addObject("order", order);
        modelAndView.setViewName("purchase/editOrder");
        return modelAndView;
    }
    @RequestMapping(value = "/purchase/editOrder", method = RequestMethod.POST)
    public ModelAndView purchaseEditOrder(@ModelAttribute("order")Order order) {
        ModelAndView modelAndView                                                                                                                                                                     = new ModelAndView();
        int weight =  order.getWeight();
        int id = order.getId();
        order = orderService.findOrderById(id);
        orderService.editOrder(order, weight);
        modelAndView.addObject("successMessage", "Зміни успішно внесено");
        return modelAndView;
    }
    @RequestMapping(value = "/purchase/closeOrder/{id}", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable(value = "id") int id){
        ModelAndView modelAndView = new ModelAndView();
        Order order =  orderService.findOrderById(id);
        modelAndView.addObject("order", order);
        modelAndView.addObject("listAllProducts", productService.listAllProducts());
        modelAndView.setViewName("/purchase/closeOrder");
        return modelAndView;
    }
}
