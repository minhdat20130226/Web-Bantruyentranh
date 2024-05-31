package cdweb.sellstories.sellstories.service.impl;

import cdweb.sellstories.sellstories.dto.UserDTO;
import cdweb.sellstories.sellstories.dto.UserRoleDTO;
import cdweb.sellstories.sellstories.entity.Role;
import cdweb.sellstories.sellstories.entity.User;
import cdweb.sellstories.sellstories.entity.UserRoles;
import cdweb.sellstories.sellstories.exception.UserNotFoundException;
import cdweb.sellstories.sellstories.mapper.UserRoleMapper;
import cdweb.sellstories.sellstories.repository.RoleRepository;
import cdweb.sellstories.sellstories.repository.UserRepository;
import cdweb.sellstories.sellstories.repository.UserRolesRepository;
import cdweb.sellstories.sellstories.service.UserRolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRolesImpl implements UserRolesService {
    private final UserRolesRepository userRoleRepository;

    @Override
    public void saveUserRoleWithIdUser(Long idUserDTO) {
        UserRoles userRoles = new UserRoles(idUserDTO,Role.builder().id(2L).build());
        userRoleRepository.save(userRoles);
    }
}
