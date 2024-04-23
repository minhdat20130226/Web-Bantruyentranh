package cdweb.sellstories.sellstories.service.impl;

import cdweb.sellstories.sellstories.dto.UserDTO;
import cdweb.sellstories.sellstories.entity.User;
import cdweb.sellstories.sellstories.mapper.UserMapper;
import cdweb.sellstories.sellstories.repository.PasswordResetTokenRepository;
import cdweb.sellstories.sellstories.repository.UserRepository;
import cdweb.sellstories.sellstories.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDTO registerAccount(UserDTO info, String passWord) {
        User registerInfo = UserMapper.registerUser(info, passWord);
        User saveRegisterInfo = userRepository.save(registerInfo);
        /*       TODO send email to user with token */
        return UserMapper.mapToUserDTO_Register(saveRegisterInfo);
    }

    @Override
    public UserDTO accountExist(String email, String password) {
        // thuc hien so sanh pass word nhap vao va pass bi ma hoa
        Optional<User> userOptional = userRepository.findByEmailAndPassWord(email, password);
        if (!userOptional.isPresent()) return null;
        return UserMapper.userInfo(userOptional.get());
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Long findIdByEmail(String email) {
        return userRepository.findIdByEmail(email);
    }


}
