package com.landvibe.codefolio.config.security;

import com.landvibe.codefolio.model.Role;
import com.landvibe.codefolio.model.User;
import com.landvibe.codefolio.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Oauth2SuccessHandler implements AuthenticationSuccessHandler {

    private UserService userService;

    public Oauth2SuccessHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth)
            throws IOException, ServletException {
        OAuth2Authentication oAuth = (OAuth2Authentication) auth;
        OAuth2AuthenticationDetails oAuthDetails = (OAuth2AuthenticationDetails) oAuth.getDetails();
        Map<String, Object> githubUser = (LinkedHashMap) oAuth.getUserAuthentication().getDetails();

        String email = (String) githubUser.get("email");
        String avatar = (String) githubUser.get("avatar_url");
        String name = (String) githubUser.get("name");
        String githubId = (String) githubUser.get("login");
        String token = oAuthDetails.getTokenValue();

        List<Role> roles = oAuth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .map(s -> new Role(s))
                .collect(Collectors.toList());

        Optional<User> user = userService.getUserByUsername(email);
        if (user.isPresent()) {
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(
                    user.get().getUsername(), user.get().getPassword(), user.get().getAuthorities()));
            res.sendRedirect("/");
        } else {
            User newUser = new User(email, githubId, roles, token);
            userService.create(newUser, Optional.of("ROLE_OAUTH"));
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(
                    newUser.getUsername(), newUser.getPassword(), newUser.getAuthorities()));
            res.sendRedirect("/signup/"+newUser.getUsername());
        }
    }
}
