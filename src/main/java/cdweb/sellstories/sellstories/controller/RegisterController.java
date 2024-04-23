package cdweb.sellstories.sellstories.controller;

import cdweb.sellstories.sellstories.dto.UserDTO;
import cdweb.sellstories.sellstories.dto.UserRoleDTO;
import cdweb.sellstories.sellstories.service.PasswordResetTokenService;
import cdweb.sellstories.sellstories.service.UserRolesService;
import cdweb.sellstories.sellstories.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRolesService userRolesService;
    @Autowired
    private PasswordResetTokenService passwordResetTokenService;

    @PostMapping("/register")
    public ResponseEntity<String> registerInfo(@RequestBody Map<String, Object> request) {
        // Trích xuất thông tin userDTO từ request body
        Map<String, Object> userDTOData = (Map<String, Object>) request.get("userDTO");
        String reqEmail = (String) userDTOData.get("email");
        // email ton tai
        if (userService.existsByEmail(reqEmail))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email đã được đăng ký tài khoản");

        UserDTO userDTO = UserDTO.builder()
                .gender((String) userDTOData.get("gender"))
                .fullName((String) userDTOData.get("fullName"))
                .email(reqEmail)
                .birthDate(LocalDate.parse((String) userDTOData.get("birthDate")))
                .build();
        // Ma hoa mat khau truoc khi save vao DB
        String passWord = (String) request.get("passWord");
        Long userID = userService.registerAccount(userDTO, passWord).getId();
//        passwordResetTokenService.initTokenUser(userID);
/*
    Phân quyền tài khoản khi register OK
     userRolesService.saveUserRole(UserRoleDTO.builder()
                .idUser(userID).build());

 */
  /*
    Gửi token xác thực tài khoản mơới đăng ký

 */

        return ResponseEntity.ok("Vui lòng vào email bạn vừa đăng ký xác thực tài khoản");
    }

    @PostMapping("/registerr")
    public ResponseEntity<HttpResponse> registerInfor(@RequestBody Map<String, Object> request) {
        // Trích xuất thông tin userDTO từ request body
        Map<String, Object> userDTOData = (Map<String, Object>) request.get("userDTO");
        String reqEmail = (String) userDTOData.get("email");
        // email ton tai
        if (userService.existsByEmail(reqEmail))
            return ResponseEntity.created(URI.create("")).body(
                    HttpResponse.builder()
                            .timeStamp(LocalDateTime.now().toString())
                            .data(Map.of("user", "null"))
                            .message("Email đã được đăng ký tài khoản")
                            .status(HttpStatus.BAD_REQUEST)
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .build()
            );

        UserDTO userDTO = UserDTO.builder()
                .gender((String) userDTOData.get("gender"))
                .fullName((String) userDTOData.get("fullName"))
                .email(reqEmail)
                .birthDate(LocalDate.parse((String) userDTOData.get("birthDate")))
                .build();
        // Ma hoa mat khau truoc khi save vao DB
        String passWord = (String) request.get("passWord");
        UserDTO user = userService.registerAccount(userDTO, passWord);


/*
    Phân quyền tài khoản khi register va khoi tao token xac thuc
 if(user!=null){
        passwordResetTokenService.initTokenUser(user);
        userRolesService.saveUserRole(user);
    }

 */
  /*
    Gửi token xác thực tài khoản mơới đăng ký

 */

        return ResponseEntity.created(URI.create("")).body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("user", user))
                        .message("Vui lòng vào email bạn vừa đăng ký xác thực tài khoản")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }
}
