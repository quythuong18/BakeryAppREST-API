package com.quythuong.BakeryManagementSystem.AppUser;

import com.quythuong.BakeryManagementSystem.utils.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    Optional<AppUser> findByUsername(String username);

    List<AppUser> findByRole(Role role);
}
