package com.phalguni.jobportal.entity;
import jakarta.persistence.*; import lombok.*; import java.math.BigDecimal; import java.time.LocalDateTime;
@Entity @Table(name="jobs") @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Job {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id;
 @Column(nullable=false) String title; @Column(nullable=false,length=4000) String description;
 String location; String skills; BigDecimal minSalary; BigDecimal maxSalary;
 @Enumerated(EnumType.STRING) JobType jobType; boolean remote; boolean active; LocalDateTime postedAt;
 @ManyToOne(fetch=FetchType.EAGER,optional=false) Company company;
 @ManyToOne(fetch=FetchType.EAGER,optional=false) AppUser postedBy;
}
