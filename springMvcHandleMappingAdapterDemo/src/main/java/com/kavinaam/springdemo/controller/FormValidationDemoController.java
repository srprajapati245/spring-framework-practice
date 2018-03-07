package com.kavinaam.springdemo.controller;

import com.kavinaam.springdemo.domain.OrganizationRepresentative;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("formValidationDemo")
public class FormValidationDemoController {

    private static Logger LOGGER = LoggerFactory.getLogger(FormValidationDemoController.class);

    @RequestMapping("/home")
    public ModelAndView home(Model model) {
        return new ModelAndView("test/formValidationTestViews/formValidationHome", "organizationRepresentative", new OrganizationRepresentative());
    }

    @RequestMapping(value = "/registerOrpRep", method = RequestMethod.POST)
    public String organizationRepresentativeRegistration(@Valid @ModelAttribute("organizationRepresentative") OrganizationRepresentative organizationRepresentative, BindingResult bindingResult, Model model) {
        // debug code
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

            return "test/formValidationTestViews/formValidationHome";
        } else {
            model.addAttribute("organizationRepresentative", organizationRepresentative);
            return "test/formValidationTestViews/formValidationResult";
        }
    }

}
