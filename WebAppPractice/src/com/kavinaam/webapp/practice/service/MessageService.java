package com.kavinaam.webapp.practice.service;

import java.util.ArrayList;
import java.util.List;

public class MessageService {

    public List<String> getWelcomeMessage(String name){
        List<String> welcomeMessage = new ArrayList<>();
        welcomeMessage.add("Hello!");
        welcomeMessage.add(name);
        welcomeMessage.add(", Welcome to spring course ;-)");

        return welcomeMessage;
    }
}
