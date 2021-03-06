package com.landvibe.codefolio.service;

import com.landvibe.codefolio.error.UserExistException;
import com.landvibe.codefolio.model.Role;
import com.landvibe.codefolio.model.User;
import com.landvibe.codefolio.repository.RoleRepository;
import com.landvibe.codefolio.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username + "는 존재하지 않는 유저입니다.");
        }
        return user;
    }

    public Optional<User> getUserByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }

    @Transactional
    public User create(User newUser, List<Role> newRoles) {
        boolean exists = userRepository.existsByName(newUser.getUsername());
        if (exists) {
            throw new UserExistException(newUser.getUsername() + "는 이미 존재하는 유저입니다.");
        }

        // Set Role
        List<Role> roles = new ArrayList<>();
        for(Role role : newRoles){
            roles.add(getNormalUserRole(role.getName()));
        }
        newUser.setRoles(roles);

        return userRepository.save(newUser);
    }

    // 캐싱 필요
    Role getNormalUserRole(String normalUserRoleName) {
        Role normalUserRole = roleRepository.findRoleByName(normalUserRoleName);
        if (normalUserRole == null) {
            return new Role(normalUserRoleName);
        } else {
            return normalUserRole;
        }
    }

    @Transactional
    public void update(String username, String name, String job) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username + "는 존재하지 않는 유저입니다.");
        }
        user.setName(name);
        user.setJob(job);
    }

    @Transactional
    public void delete(User user) {
        long uid = user.getId();
        boolean exists = userRepository.exists(uid);
        if (!exists) {
            throw new UsernameNotFoundException(user.getUsername() + "는 존재하지 않는 유저입니다.");
        }
        userRepository.delete(uid);
    }
}
