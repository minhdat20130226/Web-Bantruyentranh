package cdweb.sellstories.sellstories.service;

public interface EmailService {
    void sendSimpleMailMessage(String name,String to,String token);
}
