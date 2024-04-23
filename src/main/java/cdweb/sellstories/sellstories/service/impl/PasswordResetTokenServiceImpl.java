package cdweb.sellstories.sellstories.service.impl;

import cdweb.sellstories.sellstories.dto.UserDTO;
import cdweb.sellstories.sellstories.entity.PasswordResetToken;
import cdweb.sellstories.sellstories.entity.User;
import cdweb.sellstories.sellstories.mapper.PasswordResetTokenMapper;
import cdweb.sellstories.sellstories.repository.PasswordResetTokenRepository;
import cdweb.sellstories.sellstories.repository.UserRepository;
import cdweb.sellstories.sellstories.service.PasswordResetTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {
    private final PasswordResetTokenRepository passwordResetTokenRepository;
    private final UserRepository userRepository;
    @Override
    public void initTokenUser(UserDTO userDTO) {
        PasswordResetToken passwordResetToken = PasswordResetTokenMapper.mapToPasswordResetToken_VerifyToken(userDTO);
        passwordResetTokenRepository.save(passwordResetToken);
    }

    @Override
    public boolean verifyToken(String token) {
        PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByTokenValue(token);
        User user = passwordResetToken.getUser();
        user.setIsActive("Đang hoạt động");
        userRepository.save(user);
        passwordResetTokenRepository.delete(passwordResetToken);
        return true;
    }
}
