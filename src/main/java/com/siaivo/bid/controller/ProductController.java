package com.siaivo.bid.controller;

import com.siaivo.bid.model.Product;
import com.siaivo.bid.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value="/sales/allProducts", method = RequestMethod.GET)
    public ModelAndView allProducts(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allProducts", productService.listAllProducts());
        modelAndView.setViewName("/sales/allProducts");
        return modelAndView;
    }
    @RequestMapping(value="/sales/productRegistration", method = RequestMethod.GET)
    public ModelAndView productRegistration(){
        ModelAndView modelAndView = new ModelAndView();
        Product product = new Product();
        modelAndView.addObject("product", product);
        modelAndView.setViewName("/sales/productRegistration");
        return modelAndView;
    }

    @RequestMapping(value = "/sales/productRegistration", method = RequestMethod.POST)
    public ModelAndView createNewProduct(@Valid Product product, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Product productExists = productService.findByName(product.getName());
                if (productExists != null) {
            bindingResult
                    .rejectValue("name", "error.product",
                            "Такий продукт вже зареєстровано");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("/sales/productRegistration");
        } else {
            productService.saveProduct(product);
            modelAndView.addObject("successMessage", "Продукт успішно додано");
            modelAndView.addObject("product", new Product());
            modelAndView.setViewName("/sales/productRegistration");
        }
        return modelAndView;
    }
 }
