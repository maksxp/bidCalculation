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

    @RequestMapping(value="/siaivo/allProducts", method = RequestMethod.GET)
    public ModelAndView allProducts(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allProducts", productService.listAllProducts());
        modelAndView.setViewName("/siaivo/allProducts");
        return modelAndView;
    }
    @RequestMapping(value="/siaivo/productRegistration", method = RequestMethod.GET)
    public ModelAndView productRegistration(){
        ModelAndView modelAndView = new ModelAndView();
        Product product = new Product();
        modelAndView.addObject("product", product);
        modelAndView.setViewName("/siaivo/productRegistration");
        return modelAndView;
    }

    @RequestMapping(value = "/siaivo/productRegistration", method = RequestMethod.POST)
    public ModelAndView createNewProduct(@Valid Product product, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Product productExists = productService.findByName(product.getName());
                if (productExists != null) {
            bindingResult
                    .rejectValue("name", "error.product",
                            "Такий продукт вже зареєстровано");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("/siaivo/productRegistration");
        } else {
            productService.saveProduct(product);
            modelAndView.addObject("successMessage", "Продукт успішно додано");
            modelAndView.addObject("product", new Product());
            modelAndView.setViewName("/siaivo/productRegistration");
        }
        return modelAndView;
    }
 }
