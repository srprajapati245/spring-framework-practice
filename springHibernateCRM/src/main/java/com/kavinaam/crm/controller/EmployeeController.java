package com.kavinaam.crm.controller;

import com.kavinaam.crm.entity.Company;
import com.kavinaam.crm.entity.Employee;
import com.kavinaam.crm.service.CompanyService;
import com.kavinaam.crm.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private static Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CompanyService companyService;

    @GetMapping("/list") //@RequestMapping(path = "/list", method = RequestMethod.GET)
    public String listEmployee(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("companyId", id);
        model.addAttribute("employees", employeeService.getEmployeeByCompanyId(id));
        return "listOfEmployee";
    }

    @GetMapping("/add")
    public ModelAndView addEmployee(@RequestParam("companyId") Integer companyId) {
        ModelAndView modelAndView = new ModelAndView("addEmployee");
        Employee employee = new Employee();
        employee.setCompany(companyService.getCompanyById(companyId));
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        employeeService.addOrUpdateEmployee(employee);
        return "redirect:/employee/list?id="+employee.getCompany().getId();
    }

    @GetMapping("/update")
    public String updateEmployee(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "addEmployee";
    }

    @GetMapping("/delete")
    public String deleteCompany(@RequestParam("id") Integer id, Model model) {
        Integer companyId = employeeService.getEmployeeById(id).getCompany().getId();
        employeeService.deleteEmployee(id);
        return "redirect:/employee/list?id="+companyId;
    }


}
