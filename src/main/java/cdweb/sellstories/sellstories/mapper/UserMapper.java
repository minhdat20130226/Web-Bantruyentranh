package cdweb.sellstories.sellstories.mapper;

import cdweb.sellstories.sellstories.dto.UserDTO;
import cdweb.sellstories.sellstories.entity.User;


public class UserMapper {

    public static UserDTO mapToUserDTO_Register(User user) {
        return new UserDTO(user);
    }
    public static User registerUser(UserDTO info,String passWord){
        return new User(info,passWord) ;
    }

    public static UserDTO userInfo(User user) {
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
                .build();
    }
}
