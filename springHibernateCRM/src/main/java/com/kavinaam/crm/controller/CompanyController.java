package com.kavinaam.crm.controller;

import com.kavinaam.crm.entity.Company;
import com.kavinaam.crm.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/company")
public class CompanyController {

    private static Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private CompanyService companyService;

    //@GetMapping("/list") //@RequestMapping(path = "/list", method = RequestMethod.GET)
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listCompany(Model model) {
        model.addAttribute("companies", companyService.getCompanyList());
        return "listOfCompany";
    }

    @GetMapping("/add")
    public ModelAndView addCompany() {
        return new ModelAndView("addCompany", "company", new Company());
    }

    @PostMapping("/save")
    public String saveCompany(@ModelAttribute("company") Company company, Model model) {
        companyService.addOrUpdateCompany(company);
        return "redirect:/company/list";
    }

    @GetMapping("/update")
    public String updateCompany(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("company", companyService.getCompanyById(id));
        return "addCompany";
    }

    @GetMapping("/delete")
    public String deleteCompany(@RequestParam("id") Integer id, Model model) {
        companyService.deleteCompany(id);
        return "redirect:/company/list";
    }


}
