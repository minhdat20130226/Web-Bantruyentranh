package cdweb.sellstories.sellstories.mapper;

import cdweb.sellstories.sellstories.dto.UserDTO;
import cdweb.sellstories.sellstories.entity.User;

import java.time.LocalDateTime;


public class UserMapper {

    public static UserDTO mapToUserDTO_Register(User user) {

        return new UserDTO(user);
    }

    public static User mapToUser(UserDTO info){
        return User.builder()
                .fullName(info.getFullName())
                .gender(info.getGender())
                .email(info.getEmail())
                .birthDate(info.getBirthDate())
                .address(info.getAddress())
                .numberPhone(info.getNumberPhone())
                .province(info.getProvince())
                .district(info.getDistrict())
                .isActive(info.getIsActive())
                .passWord(info.getPassword())
                .build();
    }


    public static UserDTO mapToUserDTO(User user) {
        return UserDTO.builder()
                .fullName(user.getFullName())
                .gender(user.getGender())
                .email(user.getEmail())
                .birthDate(user.getBirthDate())
                .address(user.getAddress())
                .numberPhone(user.getNumberPhone())
                .province(user.getProvince())
                .district(user.getDistrict())
                .isActive(user.getIsActive())
                .password(user.getPassWord())
                .build();
    }
}
