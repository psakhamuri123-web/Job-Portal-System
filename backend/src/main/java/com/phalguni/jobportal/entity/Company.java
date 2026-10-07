package com.phalguni.jobportal.entity;
import jakarta.persistence.*; import lombok.*;
@Entity @Table(name="companies") @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Company {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id;
 @Column(nullable=false) String name; String industry; String location; String website; String description;
}
