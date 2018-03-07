package com.kavinaam.springdemo.controller.test;

import com.kavinaam.springdemo.domain.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelAttributeDemoController {

    private static Logger LOGGER = LoggerFactory.getLogger(ModelAttributeDemoController.class);

    @RequestMapping(value = "/home")
    public String home(){
        LOGGER.info("INSIDE home: " + System.currentTimeMillis());
        return "modeAttributeHome";
    }

    // version 2 of our home() method
    @RequestMapping(value = "/home2")
    public ModelAndView home2(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("modeAttributeHome");
        modelAndView.addObject("command", new Address());
        return modelAndView;
    }

    // version 3 of our home() method
    @RequestMapping(value = "/home3")
    public ModelAndView home3(){
        ModelAndView modelAndView = new ModelAndView("modeAttributeHome");
        modelAndView.addObject("anAddress", new Address());
        return modelAndView;
    }

    // version 4 of our home() method
    @RequestMapping(value = "/home4")
    public ModelAndView home4(){
        return new ModelAndView("modeAttributeHome", "anAddress", new Address("Melbourne", "3000"));
    }

    // version 5 of our home() method
    @RequestMapping(value = "/home5")
    public String home5(Model model){
        model.addAttribute("anAddress", new Address("Brisbane", "4000"));
        return "modeAttributeHome";
    }


    /*
    Test series of determine the nature of @ModelAttribute annotation (on a method)
     */

    // Test 1: Demostrating the usage of @ModelAttribute annotation (on a method to add multiple attributes)
    @ModelAttribute
    public void modelAttributeTest1(Model model){
        LOGGER.info("INSIDE modelAttributeTest1: " + System.currentTimeMillis());
        model.addAttribute("testdata1A", "Welcome to the @ModelAttribute Test Bed!");
        model.addAttribute("testdata1B", "We will test both usages of the @ModelAttribute, on methods and on method arguments");
    }

    // Test 2: Demostrating the usage of @ModelAttribute annotation (on a method)
    @ModelAttribute(name = "testdata2")
    public String modelAttributeTest2(){
        LOGGER.info("INSIDE modelAttributeTest2");
        return "We will conduct a series of test here";
    }

    // Test 3: Demostrating the usage of @ModelAttribute annotation (on a method) to implicity add a attribute
    // by returning it and also demostrating the usage of the 'value' attribute of the @ModelAttribute annotation (on a method)
    @ModelAttribute(value = "testdata3")
    public Address modelAttributeTest3(){
        LOGGER.info("INSIDE modelAttributeTest3");
        return new Address("Adelaide", "5000");
    }

    // Test 4: Demostrating the default naming strategy of the @ModelAttribute annotation (on a method)
    @ModelAttribute
    public Address modelAttributeTest4(){
        LOGGER.info("INSIDE modelAttributeTest4");
        return new Address("Sydney", "2000");
    }

    // Test 5: Testing the @ModelAttribute with 'value' attribute and default binding
    @RequestMapping(value = "/test5")
    public String modelAttributeTest5(@ModelAttribute(value = "anAddress") Address address, ModelMap modelMap) {
        modelMap.addAttribute("testdata5A", address.getCity());
        modelMap.addAttribute("testdata5B", address.getZipCode());
        return "modelAttributeTest";
    }

    // Test 6: Test tp determine the nature of how the @ModelAttribute(On method) adj @RequestMapping
    // work with no explicit logical view name
    @RequestMapping(value = "/modelAttributeTest")
    @ModelAttribute("testdata6")
    public Address modelAttributeTest6() {
        return new Address("Canberra", "2600");
    }
}
