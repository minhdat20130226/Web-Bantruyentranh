package cdweb.sellstories.sellstories.controller;

import cdweb.sellstories.sellstories.dto.InfoLoginDTO;
import cdweb.sellstories.sellstories.dto.UserDTO;
import cdweb.sellstories.sellstories.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<InfoLoginDTO> login(@RequestBody UserDTO userDTO) {

        UserDTO userInfo = userService.accountExist(userDTO.getEmail(), userDTO.getPassword());
        System.err.println(userDTO.getEmail()+ " " + userDTO.getPassword());
        //tài khoản chưa đăng ký
        if (userInfo == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new InfoLoginDTO(null, "Tài khoản chưa được đăng ký"));
        // tài khoản đã đăng ký nhưng chưa xác thực qua email

         else
             if(userInfo.getIsActive().equalsIgnoreCase("Không hoạt động"))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new InfoLoginDTO(userInfo, "Vui lòng vào email để kích hoạt tài khoản"));


        // //Đăng nhập thành công ->điều hướng đến trăng Home

        return ResponseEntity.ok(InfoLoginDTO.builder().info(userInfo).mess("Login successful").build());
    }

}
