package cdweb.sellstories.sellstories.entity;

import cdweb.sellstories.sellstories.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false)
    private Long id;
    @Column(name = "username")
    private String userName;
    @Column(name = "password",nullable = false)
    private String passWord;
    @Column(name = "fullname")
    private String fullName;
    private String gender;

    @Column(unique = true,updatable = false,nullable = false)
    private String email;
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    private String address;

    @Column(name = "number_phone")
    private String numberPhone;

    private String province;

    private String district;

    @Column(name = "date_registered")
    @CreatedDate
    private LocalDateTime  dateRegistered;

    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private LocalDateTime lastLogin;

    @Column(name = "is_active")
    private String isActive;
    public User(UserDTO userDTO,String passWord) {
        this.gender = userDTO.getGender();
        this.fullName = userDTO.getFullName();
        this.email = userDTO.getEmail();
        this.birthDate = userDTO.getBirthDate();
        this.isActive = "Không hoạt động";
        this.dateRegistered = LocalDateTime.now();
        this.passWord = passWord;
    }

    public User(Long id) {
        this.id = id;
    }
}
