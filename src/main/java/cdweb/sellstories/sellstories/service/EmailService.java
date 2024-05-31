package cdweb.sellstories.sellstories.service;

public interface EmailService {
    void sendSimpleMailMessageRegisterAccount(String name,String to,String token);
}
