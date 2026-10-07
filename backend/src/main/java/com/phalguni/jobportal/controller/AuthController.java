package com.phalguni.jobportal.controller;
import com.phalguni.jobportal.dto.*; import com.phalguni.jobportal.security.*; import lombok.RequiredArgsConstructor; import org.springframework.security.authentication.*; import org.springframework.security.core.userdetails.UserDetailsService; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/auth") @RequiredArgsConstructor public class AuthController{
 private final AuthenticationManager manager;private final UserDetailsService users;private final JwtService jwt;
 @PostMapping("/login") public LoginResponse login(@RequestBody LoginRequest r){manager.authenticate(new UsernamePasswordAuthenticationToken(r.username(),r.password()));var u=users.loadUserByUsername(r.username());String role=u.getAuthorities().iterator().next().getAuthority().replace("ROLE_","");return new LoginResponse(jwt.generate(u),u.getUsername(),role);}
}
