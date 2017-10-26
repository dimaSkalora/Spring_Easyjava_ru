package spring_framework.head_01.becomejavasenior_com.becomejavasenior.spring.di.services;

public class EmailService implements MessageService {
    @Override
    public boolean sendMessage(String msg, String rec) {
        System.out.println("Email Sent to " + rec + " with Message=" + msg);
        return true;
    }
}