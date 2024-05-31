package cdweb.sellstories.sellstories.controller;

import cdweb.sellstories.sellstories.dto.UserDTO;
import cdweb.sellstories.sellstories.service.EmailService;
import cdweb.sellstories.sellstories.service.PasswordResetTokenService;
import cdweb.sellstories.sellstories.service.UserRolesService;
import cdweb.sellstories.sellstories.service.UserService;
import cdweb.sellstories.sellstories.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRolesService userRolesService;
    @Autowired
    private PasswordResetTokenService passwordResetTokenService;
    @Autowired
    private EmailService emailService;
    //
    @PostMapping("/register")
    public ResponseEntity<HttpResponse> userDateRegister(@RequestBody UserDTO userData) {
        // Trích xuất thông tin userDTO từ request body
        System.err.println(userData);
        String reqEmail = userData.getEmail();
        // email ton tai
        if (userService.existsByEmail(reqEmail))
            return ResponseEntity.created(URI.create("")).body(
                    HttpResponse.builder()
                            .timeStamp(LocalDateTime.now().toString())
                            .data(null)
                            .message("Email đã được đăng ký tài khoản")
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build());

        Long registerSuccess = userService.registerAccount(userData);
        String tokenValue = JwtTokenUtil.generateToken(String.valueOf(2L));
        if (registerSuccess != null) {
            // khoi tao token

            passwordResetTokenService.initTokenUserWithUserRegister(registerSuccess,tokenValue);
            // Gửi email với token xác thực tài khoản
//            emailService.sendSimpleMailMessageRegisterAccount(userData.getEmail(), "Xác thực tài khoản",tokenValue);

            // phan quyen quyen tai khoan
            userRolesService.saveUserRoleWithIdUser(registerSuccess);
        }

        return ResponseEntity.created(URI.create("")).body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("tokenValue",tokenValue))
                        .message("Kiểm tra Email và kích hoạt theo hướng dẫn để hoàn tất đăng ký tài khoản!!")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }
}
