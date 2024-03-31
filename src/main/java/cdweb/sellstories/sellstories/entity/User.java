package cdweb.sellstories.sellstories.entity;

import cdweb.sellstories.sellstories.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

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
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;

    private String address;

    @Column(name = "number_phone")
    private String numberPhone;

    private String province;

    private String district;

    @Column(name = "date_registered", columnDefinition = "datetime DEFAULT GETDATE()")
    private Date dateRegistered;

    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    @Column(name = "is_active",columnDefinition = "INT DEFAULT 0")
    private boolean isActive;
    public User(UserDTO userDTO,String passWord) {
        this.gender = userDTO.getGender();
        this.fullName = userDTO.getFullName();
        this.email = userDTO.getEmail();
        this.birthDate = userDTO.getBirthDate();
        this.passWord = passWord;
    }
}
