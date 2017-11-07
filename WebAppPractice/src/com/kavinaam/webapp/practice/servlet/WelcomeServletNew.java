package com.kavinaam.webapp.practice.servlet;

import com.kavinaam.webapp.practice.service.MessageService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/WelcomeServletNew")
public class WelcomeServletNew extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MessageService messageService = new MessageService();
        List<String> welcomeMessage = messageService.getWelcomeMessage("Sanjay");

        request.setAttribute("welcomeMessage", welcomeMessage);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("indexNew.jsp");
        requestDispatcher.forward(request, response);
    }
}
