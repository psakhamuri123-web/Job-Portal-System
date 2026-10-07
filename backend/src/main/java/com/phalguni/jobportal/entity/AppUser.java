package com.phalguni.jobportal.entity;
import jakarta.persistence.*; import lombok.*;
@Entity @Table(name="users") @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class AppUser {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id;
 @Column(nullable=false,unique=true) String username;
 @Column(nullable=false) String password;
 String fullName; String email;
 @Enumerated(EnumType.STRING) @Column(nullable=false) Role role;
}
