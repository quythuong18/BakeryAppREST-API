package com.quythuong.BakeryManagementSystem.AppUser;

import com.quythuong.BakeryManagementSystem.utils.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {
    private final AppUserRepository appUserRepository;
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser> getAllCustomer() {
        List<AppUser> appUserList = appUserRepository.findByRole(Role.ROLE_CUSTOMER);
        if(!appUserList.isEmpty()) {
            return appUserList;
        }
        return null;
    }

    public AppUser getUserById(Integer appUserId) {
        return appUserRepository.findById(appUserId).orElseThrow(() -> new IllegalStateException("app user with " + appUserId + " does not exist"));
    }
}
