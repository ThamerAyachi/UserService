package io.rasputin.userservice.service;

import io.rasputin.userservice.model.AppUser;
import io.rasputin.userservice.model.Role;

import java.util.List;

public interface AppUserService {
    AppUser saveUser(AppUser appUser);
    Role saveRole(Role role);
    void AddRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
