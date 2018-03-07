package com.kavinaam.springdemo.controller;

import com.kavinaam.springdemo.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping("homeOld")
    public String homeOld(){
        return "home-old";
    }

    @RequestMapping("jstlsql")
    public String listOrganizationUsingSqlTag(){
        return "listOrganization1";
    }

    @RequestMapping("/service")
    public String listOrganizationUsingService(Model model){
        model.addAttribute("organizationList", organizationService.getOrganizationList());
        return "listOrganization2";
    }

    @RequestMapping("/location")
    public String addLocation(){
        return "location";
    }

    @RequestMapping("/listOrgs")
    public String listOrganizations(Model model){
        model.addAttribute("organizationList", organizationService.getOrganizationList());
        return "listOrganizations";
    }
}
