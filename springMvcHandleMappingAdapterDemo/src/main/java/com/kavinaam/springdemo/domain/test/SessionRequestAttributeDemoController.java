package com.kavinaam.springdemo.domain.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes(names = {"visitordata", "visitorcount"})
@RequestMapping("/visitorRegister")
public class SessionRequestAttributeDemoController {

    @Autowired
    private VisitorService visitorService;

    private static Logger LOGGER = LoggerFactory.getLogger(SessionRequestAttributeDemoController.class);

    @RequestMapping(value = "/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("test/sessionRequestAttributeViews/sessionRequestAttributeHome", "visitorStats", new VisitorData());
        return modelAndView;
    }

    @ModelAttribute("visitordata")
    public VisitorData addVisitor() {
        List<Visitor> visitors = new ArrayList<Visitor>();
        VisitorData visitordata = new VisitorData(null, null, visitors);
        return visitordata;
    }

    @ModelAttribute("visitorcount")
    public VisitorCount addVisitorCount(){
        return new VisitorCount(0);
    }

    @RequestMapping(value = "/visitor", method = RequestMethod.POST)
    public String getVisitors(@ModelAttribute("visitor") VisitorData currentVisitor,
                              HttpSession httpSession,
                              SessionStatus sessionStatus,
                              HttpServletRequest request,
                              @SessionAttribute(name="sessionStartTime")LocalDateTime startTime,
                              @RequestAttribute(name = "currentTime") LocalDateTime clockTime,
                              Model model) {
        VisitorData visitorDataFromSession = (VisitorData) httpSession.getAttribute("visitordata");
        visitorService.registerVisitor(visitorDataFromSession, currentVisitor);
        VisitorCount visitorCount = (VisitorCount) httpSession.getAttribute("visitorcount");
        visitorService.updateCount(visitorCount);

        if(visitorCount.getCount() == 5) {
            sessionStatus.setComplete();
            httpSession.invalidate();
        }

        model.addAttribute("timeHeading", visitorService.describeCurrentTime(clockTime));
        model.addAttribute("durationHeading", visitorService.describeCurrentDuration(visitorService.computeDuration(startTime)));

        /*Map<String, Object> modalMap = model.asMap();
        modalMap.put("timeHeading", visitorService.describeCurrentTime(clockTime));
        modalMap.put("durationHeading", visitorService.describeCurrentDuration(visitorService.computeDuration(startTime)));*/

        // debug code
        /*if(request.getMethod().equalsIgnoreCase("POST")) {
            LOGGER.info("This is a POST request");
        } else {
            LOGGER.info("This is a GET request");
        }*/

        return "test/sessionRequestAttributeViews/sessionRequestAttributeResult";
    }
}
