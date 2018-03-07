package com.tutorial.web;

import com.sun.org.apache.regexp.internal.RE;
import com.tutorial.model.User;
import org.apache.commons.logging. Log;
import org.apache.commons.logging. LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rudra Automation on 22/06/2017.
 */
@Controller
public class UserController {

    private final Log log = LogFactory.getLog(UserController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model){
        log.debug("index()");
        return "redirect:/users";
    }

    //list page
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showAllUsers(Model model){
        return null;
    }

    // save or update user
    // 1. @ModelAttribute bind form value
    // 2. @Validated form validator
    // 3. RedirectAttributes for flash value
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String saveOrUpdateUser(@ModelAttribute("userForm") @Validated User user, BindingResult result, Model model, final RedirectAttributes redirectAttributes){
        return null;
    }

    // show add user form
    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String showAddUserForm(Model model){
        return null;
    }

    // show update form
    @RequestMapping(value = "users/{id}update", method = RequestMethod.GET)
    public String showUpdateUserForm(Model model){
        return null;
    }

    // delete user form
    @RequestMapping(value = "/users/{id}/delete", method = RequestMethod.POST)
    public String deleteUser(@PathVariable("id") int id, RedirectAttributes redirectAttributes){
        return null;
    }

    // show user
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") int id, Model model){
        return null;
    }

    private void populateDefaultModel(Model model){

        List<String> frameworksList = new ArrayList<String>();
        frameworksList.add("Spring MVC");
        frameworksList.add("Struts 2");
        frameworksList.add("JSF 2");
        frameworksList.add("GWT");
        frameworksList.add("Play");
        frameworksList.add("Apache Wicket");
        model.addAttribute("framworkList", frameworksList);

        Map<String, String> skill = new LinkedHashMap<String, String>();
        skill.put("Hibernate", "Hibernate");
        skill.put("Spring", "Spring");
        skill.put("Struts", "Struts");
        skill.put("Groovy", "Groovy");
        skill.put("Grails", "Grails");
        model.addAttribute("javaSkillList", skill);

        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        model.addAttribute("numberList", numbers);

        Map<String, String> country = new LinkedHashMap<String, String>();
        country.put("US", "United Stated");
        country.put("CN", "China");
        country.put("SG", "Singapore");
        country.put("MY", "Malaysia");
        model.addAttribute("countryList", country);
    }
}
