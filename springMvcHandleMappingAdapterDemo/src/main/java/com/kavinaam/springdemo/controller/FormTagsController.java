package com.kavinaam.springdemo.controller;

import com.kavinaam.springdemo.domain.OrganizationRegistration;
import com.kavinaam.springdemo.service.test.OrganizationRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/formTagsDemo")
public class FormTagsController {

    @Autowired
    private OrganizationRegistrationService registrationService;

    @RequestMapping("/home")
    public ModelAndView home(Model model) {
        return new ModelAndView("test/formTagsTestViews/formTagsHome", "organizationRegistration", new OrganizationRegistration());
    }

    @RequestMapping(value = "/registerOrg", method = RequestMethod.POST)
    public String organizationRegistration(@ModelAttribute OrganizationRegistration organizationRegistration, Model model) {
        model.addAttribute("orgReg", organizationRegistration);
        return "test/formTagsTestViews/formTagsResult";
    }

    @ModelAttribute
    public void populateFormObjectwithData(Model model) {
        Map<String, Object> map = model.asMap();
        map.put("turnoverlist", registrationService.populateTurnover());
        map.put("orgtypelist", registrationService.populateOrgType());
        map.put("servicelengthlist", registrationService.populateServiceLengthOptions());
        map.put("registeralready", registrationService.populateRegisterAlready());
        map.put("subscriptionlist", registrationService.populateOptionalService());
        map.put("primiunservicelist", registrationService.populatePrimiunService());
        map.put("employeestrengthlist", registrationService.populateEmployeeStrengthService());
    }
}
