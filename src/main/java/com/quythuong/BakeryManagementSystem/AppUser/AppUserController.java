package com.quythuong.BakeryManagementSystem.AppUser;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class AppUserController {
    private final AppUserService appUserService;
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping(path = "customers")
    List<AppUser> getAllCustomer() {
        return appUserService.getAllCustomer();
    }

    @GetMapping(path ="{appUserId}")
    AppUser getUserById(@PathVariable("appUserId") Integer appUserId) {
        return appUserService.getUserById(appUserId);
    }
}
