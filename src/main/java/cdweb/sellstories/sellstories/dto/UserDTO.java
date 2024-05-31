package cdweb.sellstories.sellstories.dto;

import cdweb.sellstories.sellstories.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class UserDTO {
    private Long id;
    private String userName;
    private String fullName;
    private String gender;
    private String email;
    private LocalDate birthDate;
    private String numberPhone;

    private String country;
    private String province;
    private String district;
    private String street;
    private String address;

    private LocalDateTime dateRegistered;
    private String isActive;
    private String password;

    public UserDTO(User user) {
        this.id = user.getId();
        this.gender = user.getGender();
        this.fullName = user.getFullName();
        this.email = user.getEmail();
        this.birthDate = user.getBirthDate();
        this.isActive = user.getIsActive();
        this.dateRegistered = user.getDateRegistered();
        this.password = user.getPassWord();
    }

}
