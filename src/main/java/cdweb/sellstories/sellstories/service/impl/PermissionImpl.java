package cdweb.sellstories.sellstories.service.impl;

import cdweb.sellstories.sellstories.entity.Permission;
import cdweb.sellstories.sellstories.repository.PermissionRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionImpl {
    private final PermissionRepository permissionRepository;

    @PostConstruct
    public void addDefaultPermissions() {
        permissionRepository.saveAll(defaultPermissions);
    }
    List<Permission> defaultPermissions = Arrays.asList(
            new Permission(1L, "User Management", "Cho phép người dùng quản lý các tài khoản người dùng khác."),
            new Permission(2L, "Create Post", "Cho phép người dùng tạo và đăng bài viết mới trên hệ thống."),
            new Permission(3L, "Delete Post", "Cho phép người dùng xóa các bài viết đã đăng trên hệ thống."),
            new Permission(4L, "Comment Management", "Cho phép người dùng quản lý các bình luận của bài viết, bao gồm xóa bình luận và kiểm duyệt."),
            new Permission(5L, "System Settings Modification", "Cho phép người dùng thay đổi cài đặt và tùy chọn của hệ thống, bao gồm cài đặt bảo mật và giao diện người dùng.")
    );
}
