package com.quythuong.BakeryManagementSystem.AppUser;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class AppUserController {
    private final AppUserService appUserService;
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }
    @GetMapping
    List<AppUser> getAllCustomer() {
        return appUserService.getAllCustomer();
    }
}
