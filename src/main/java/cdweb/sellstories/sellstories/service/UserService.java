package cdweb.sellstories.sellstories.service;

import cdweb.sellstories.sellstories.dto.UserDTO;
import cdweb.sellstories.sellstories.entity.User;

public interface UserService{
    Long registerAccount(UserDTO info);
    UserDTO accountExist(String email,String password);
    boolean existsByEmail(String email);
    Long findIdByEmail(String email);
}
