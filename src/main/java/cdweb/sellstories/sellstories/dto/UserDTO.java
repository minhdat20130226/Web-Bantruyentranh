package cdweb.sellstories.sellstories.dto;

import cdweb.sellstories.sellstories.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String userName;
    private String fullName;
    private String gender;
    private String email;
    private LocalDate birthDate;
    private String address;
    private String numberPhone;
    private String province;
    private String district;
    private LocalDateTime dateRegistered;
    private String isActive;

    public UserDTO(User user) {
        this.id = user.getId();
        this.gender = user.getGender();
        this.fullName = user.getFullName();
        this.email = user.getEmail();
        this.birthDate = user.getBirthDate();
        this.isActive = user.getIsActive();
        this.dateRegistered = user.getDateRegistered();
    }
}
