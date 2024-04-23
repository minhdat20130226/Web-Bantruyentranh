package cdweb.sellstories.sellstories.mapper;

import cdweb.sellstories.sellstories.dto.UserDTO;
import cdweb.sellstories.sellstories.entity.PasswordResetToken;
import cdweb.sellstories.sellstories.entity.User;

public class PasswordResetTokenMapper {

    public static PasswordResetToken mapToPasswordResetToken_VerifyToken(UserDTO userDTO) {
        return new PasswordResetToken(User.builder()
                .id(userDTO.getId())
                .gender(userDTO.getGender())
                .email(userDTO.getEmail())
                .fullName(userDTO.getFullName())
                .birthDate(userDTO.getBirthDate())
                .build());
    }
}
