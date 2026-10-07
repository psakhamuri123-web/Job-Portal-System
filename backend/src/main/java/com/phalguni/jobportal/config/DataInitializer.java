package com.phalguni.jobportal.config;
import com.phalguni.jobportal.entity.*;import com.phalguni.jobportal.repository.*;import lombok.RequiredArgsConstructor;import org.springframework.boot.CommandLineRunner;import org.springframework.security.crypto.password.PasswordEncoder;import org.springframework.stereotype.Component;import java.math.BigDecimal;import java.time.LocalDateTime;
@Component @RequiredArgsConstructor public class DataInitializer implements CommandLineRunner{
 private final UserRepository users;private final CompanyRepository companies;private final JobRepository jobs;private final PasswordEncoder encoder;
 public void run(String...x){
  var r=users.findByUsername("recruiter").orElseGet(()->users.save(AppUser.builder().username("recruiter").password(encoder.encode("recruiter123")).fullName("Demo Recruiter").email("recruiter@example.com").role(Role.RECRUITER).build()));
  users.findByUsername("candidate").orElseGet(()->users.save(AppUser.builder().username("candidate").password(encoder.encode("candidate123")).fullName("Demo Candidate").email("candidate@example.com").role(Role.JOB_SEEKER).build()));
  if(companies.count()==0){var c=companies.save(Company.builder().name("TechNova Solutions").industry("Technology").location("Detroit, MI").website("https://example.com").build());
   jobs.save(Job.builder().title("Java Full Stack Developer").description("Build enterprise web applications using Java, Spring Boot and Angular.").location("Detroit, MI").skills("Java, Spring Boot, Angular, REST, MySQL, Git").minSalary(new BigDecimal("90000")).maxSalary(new BigDecimal("125000")).jobType(JobType.FULL_TIME).remote(true).active(true).postedAt(LocalDateTime.now()).company(c).postedBy(r).build());
   jobs.save(Job.builder().title("Backend Java Engineer").description("Develop scalable REST services and database integrations.").location("Lansing, MI").skills("Java, Spring Boot, JPA, SQL, AWS").minSalary(new BigDecimal("85000")).maxSalary(new BigDecimal("115000")).jobType(JobType.FULL_TIME).remote(false).active(true).postedAt(LocalDateTime.now()).company(c).postedBy(r).build());
  }
 }
}
