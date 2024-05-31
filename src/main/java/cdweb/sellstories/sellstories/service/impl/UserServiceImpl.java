package cdweb.sellstories.sellstories.service.impl;

import cdweb.sellstories.sellstories.dto.UserDTO;
import cdweb.sellstories.sellstories.entity.User;
import cdweb.sellstories.sellstories.mapper.UserMapper;
import cdweb.sellstories.sellstories.repository.UserRepository;
import cdweb.sellstories.sellstories.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public Long registerAccount(UserDTO info) {
        try {
            User registerInfo = UserMapper.mapToUser(info);
            registerInfo.setIsActive("Không hoạt động");
            registerInfo.setDateRegistered(LocalDateTime.now());

            String pwString = registerInfo.getPassWord();
            if (pwString != null && !pwString.isEmpty()) {
                // Encode the password
                String encodedPassword = passwordEncoder.encode(pwString);
                registerInfo.setPassWord(encodedPassword);
            }
            else{
                registerInfo.setPassWord("");
            }
            // Save the user registration information
            User saveRegisterInfo = userRepository.save(registerInfo);
            /* TODO send email to user with token */
            return saveRegisterInfo.getId();
        } catch (Exception e) {
            // Log the error
            System.err.println("Error registering account: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public UserDTO accountExist(String email, String password) {

        User user = userRepository.findUserByEmail(email);
        if (user != null) {
            // Kiểm tra mật khẩu
            if (passwordEncoder.matches(password, user.getPassWord())) {
                // Mật khẩu khớp, đăng nhập thành công
                return UserMapper.mapToUserDTO(user);
            }
        }
        // Đăng nhập không thành công
        return null;
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
