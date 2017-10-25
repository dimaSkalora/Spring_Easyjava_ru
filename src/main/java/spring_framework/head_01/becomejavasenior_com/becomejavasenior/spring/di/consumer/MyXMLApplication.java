package spring_framework.head_01.becomejavasenior_com.becomejavasenior.spring.di.consumer;

import spring_framework.head_01.becomejavasenior_com.becomejavasenior.spring.di.services.MessageService;

public class MyXMLApplication {
    private MessageService service;

    //constructor-based dependency injection
//  public MyXMLApplication(MessageService svc) {
//      this.service = svc;
//  }

    //setter-based dependency injection
    public void setService(MessageService svc){
        this.service=svc;
    }

    public boolean processMessage(String msg, String rec) {
        // some magic like validation, logging etc
        return this.service.sendMessage(msg, rec);
    }
}
