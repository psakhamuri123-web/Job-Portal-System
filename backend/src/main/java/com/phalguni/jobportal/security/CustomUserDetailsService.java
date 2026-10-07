package com.phalguni.jobportal.security;
import com.phalguni.jobportal.repository.UserRepository; import lombok.RequiredArgsConstructor; import org.springframework.security.core.userdetails.*; import org.springframework.stereotype.Service;
@Service @RequiredArgsConstructor public class CustomUserDetailsService implements UserDetailsService{
 private final UserRepository repo;
 public UserDetails loadUserByUsername(String u){var x=repo.findByUsername(u).orElseThrow(()->new UsernameNotFoundException("User not found"));return User.withUsername(x.getUsername()).password(x.getPassword()).roles(x.getRole().name()).build();}
}
