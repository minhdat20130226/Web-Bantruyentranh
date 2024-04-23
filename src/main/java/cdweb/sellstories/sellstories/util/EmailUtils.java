package cdweb.sellstories.sellstories.util;

public class EmailUtils {
    public static String getEmailMessage(String name, String host, String token) {
        return "Xin chào " + name + ",\n\nTài khoản mới của bạn đã được tạo. Hãy kích vào đường dẫn bên dưới để kích hoạt tài khoản.\n\n" +
                getVerificationUrl(host, token);

    }

    private static String getVerificationUrl(String host, String token) {
        return host + "/api/users?token=" + token;
    }
}
