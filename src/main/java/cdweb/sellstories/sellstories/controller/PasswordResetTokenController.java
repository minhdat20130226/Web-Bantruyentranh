package cdweb.sellstories.sellstories.controller;

import cdweb.sellstories.sellstories.entity.PasswordResetToken;
import cdweb.sellstories.sellstories.service.PasswordResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class PasswordResetTokenController {
    @Autowired
    PasswordResetTokenService passwordResetTokenService;

    @GetMapping
    public ResponseEntity<HtppResponse> confirmUserAccount(@RequestParam("token") String token) {
        boolean isSuccess = passwordResetTokenService.verifyToken(token);
        return ResponseEntity.ok().body(
          HtppResponse.builder()
                  .timeStamp(LocalDateTime.now().toString())
                  .data(Map.of("Success", isSuccess))
                  .message("Account Verified")
                  .status(HttpStatus.OK)
                  .statusCode(HttpStatus.OK.value())
                  .build()
        );
    }
}

