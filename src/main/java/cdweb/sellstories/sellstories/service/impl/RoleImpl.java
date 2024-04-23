package cdweb.sellstories.sellstories.service.impl;

import cdweb.sellstories.sellstories.entity.Role;
import cdweb.sellstories.sellstories.entity.UserRoles;
import cdweb.sellstories.sellstories.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleImpl {
    private final RoleRepository roleRepository;

    // lưu thông tin mặc định trên DB
    @PostConstruct
    public void addDefaultUserRoles() {
        roleRepository.saveAll(Arrays.asList(
                new Role(1L, "Admin", "Có toàn quyền truy cập vào tất cả các chức năng hệ thống."),
                new Role(2L, "User", "Có chức năng đăng nhập mua hàng.")
        ));
    }
}
