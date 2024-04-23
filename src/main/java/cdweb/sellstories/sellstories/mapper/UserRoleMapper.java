package cdweb.sellstories.sellstories.mapper;

import cdweb.sellstories.sellstories.dto.UserDTO;
import cdweb.sellstories.sellstories.dto.UserRoleDTO;
import cdweb.sellstories.sellstories.entity.Role;
import cdweb.sellstories.sellstories.entity.User;
import cdweb.sellstories.sellstories.entity.UserRoles;

public class UserRoleMapper {
    public static UserRoles mapToUserRole(UserDTO userDTO) {
        return UserRoles.builder()
                .user(User.builder().id(userDTO.getId()).build())
                .role(Role.builder().id(2l).build())
                .build();
    }
}
