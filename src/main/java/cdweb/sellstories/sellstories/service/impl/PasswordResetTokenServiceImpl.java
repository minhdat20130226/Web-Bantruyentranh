package cdweb.sellstories.sellstories.service.impl;

import cdweb.sellstories.sellstories.entity.PasswordResetToken;
import cdweb.sellstories.sellstories.entity.User;
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
    public void initTokenUserWithUserRegister(Long idUserDTO,String tokenValue) {
        PasswordResetToken passwordResetToken = new PasswordResetToken(idUserDTO,tokenValue);
        passwordResetTokenRepository.save(passwordResetToken);
    }

    @Override
    public boolean verifyToken(String token) {
        PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByTokenValue(token);
        boolean isValid = passwordResetToken != null;
        if(isValid) {
                User user = passwordResetToken.getUser();
                user.setIsActive("Đang hoạt động");
                userRepository.save(user);
                passwordResetTokenRepository.delete(passwordResetToken);
            }
        return isValid;
    }
}
