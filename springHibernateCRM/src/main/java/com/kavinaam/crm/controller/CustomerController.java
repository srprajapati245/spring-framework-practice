package com.kavinaam.crm.controller;

import com.kavinaam.crm.entity.Customer;
import com.kavinaam.crm.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private static Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list") //@RequestMapping(path = "/list", method = RequestMethod.GET)
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);

        LOGGER.info("Getting all customers" +customers);
        return "listCustomers";
    }

    @GetMapping("/add")
    public ModelAndView addCustomer() {
        return new ModelAndView("addCustomer", "customer", new Customer());
    }

    @PostMapping("/save")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("formErrors", bindingResult.getAllErrors());
            List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
            for(FieldError fieldError: fieldErrorList) {
                LOGGER.info("field error: " + fieldError.getDefaultMessage());
            }

            List<ObjectError> objectErrors = bindingResult.getGlobalErrors();
            for(ObjectError objectError: objectErrors) {
                LOGGER.info("global error: "+ objectError.getDefaultMessage());
            }

            return "addCustomer";
        } else {
            customerService.saveCustomer(customer);
            LOGGER.info("Save customer: "+customer);
            return "redirect:/customer/list";
        }
    }

    @GetMapping("/update")
    public String updateCustomer(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("customer", customerService.getCustomer(id));
        return "addCustomer";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") Integer id, Model model) {
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }


}
