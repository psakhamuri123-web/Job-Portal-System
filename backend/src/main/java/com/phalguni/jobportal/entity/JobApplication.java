package com.phalguni.jobportal.entity;
import jakarta.persistence.*; import lombok.*; import java.time.LocalDateTime;
@Entity @Table(name="job_applications",uniqueConstraints=@UniqueConstraint(columnNames={"job_id","applicant_id"}))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class JobApplication {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id;
 @ManyToOne(fetch=FetchType.EAGER,optional=false) Job job;
 @ManyToOne(fetch=FetchType.EAGER,optional=false) AppUser applicant;
 String resumeUrl; String coverLetter;
 @Enumerated(EnumType.STRING) ApplicationStatus status; LocalDateTime appliedAt;
}
