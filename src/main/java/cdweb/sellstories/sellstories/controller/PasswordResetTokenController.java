package cdweb.sellstories.sellstories.controller;

import cdweb.sellstories.sellstories.service.PasswordResetTokenService;
import cdweb.sellstories.sellstories.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import static cdweb.sellstories.sellstories.Constant.Constant.VALUE_TOKEN_NOLOGGING;

@RestController
public class PasswordResetTokenController {
    @Autowired
    PasswordResetTokenService passwordResetTokenService;

    @GetMapping
    public ResponseEntity<HttpResponse> activeUserAccount(@RequestParam("token") String token) {
        boolean isSuccess = passwordResetTokenService.verifyToken(token);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("Success", isSuccess))
                        .message("Account Verified")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping("/api/users")
    public ResponseEntity<String> verifyUser(@RequestParam("token") String token) {
        boolean isSuccess = passwordResetTokenService.verifyToken(token);
        if (isSuccess) {
            return ResponseEntity.ok("Token hợp lệ");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token không hợp lệ");
        }
    }

    @GetMapping("/api/checkToken")
    public ResponseEntity<Boolean> checkTokenNoLogging(@RequestParam("token") String token) {
        boolean isValid = JwtTokenUtil.validateToken(token);
        return ResponseEntity.ok().body(isValid);
    }

    @GetMapping("/api/initToken")
    public ResponseEntity<String> initTokenNoLogging() {
//        String rdValueToken = UUID.randomUUID().toString();
        String token = JwtTokenUtil.generateToken(VALUE_TOKEN_NOLOGGING);
        return ResponseEntity.ok().body(token);
    }


}

