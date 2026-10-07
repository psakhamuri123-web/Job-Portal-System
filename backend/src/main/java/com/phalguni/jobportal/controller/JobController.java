package com.phalguni.jobportal.controller;
import com.phalguni.jobportal.entity.*; import com.phalguni.jobportal.repository.*; import lombok.RequiredArgsConstructor; import org.springframework.security.core.Authentication; import org.springframework.web.bind.annotation.*; import java.time.LocalDateTime; import java.util.*;
@RestController @RequestMapping("/api/jobs") @RequiredArgsConstructor public class JobController{
 private final JobRepository jobs;private final CompanyRepository companies;private final UserRepository users;
 @GetMapping public List<Job> all(){return jobs.findAll().stream().filter(Job::isActive).toList();}
 @GetMapping("/search") public List<Job> search(@RequestParam String q){return jobs.search(q);}
 @GetMapping("/{id}") public Job one(@PathVariable Long id){return jobs.findById(id).orElseThrow(()->new RuntimeException("Job not found"));}
 @PostMapping public Job create(@RequestBody Job j,Authentication a){var u=users.findByUsername(a.getName()).orElseThrow();if(u.getRole()!=Role.RECRUITER&&u.getRole()!=Role.ADMIN)throw new RuntimeException("Recruiter access required");j.setId(null);j.setPostedBy(u);j.setPostedAt(LocalDateTime.now());j.setActive(true);if(j.getCompany()==null||j.getCompany().getId()==null)throw new RuntimeException("Company is required");j.setCompany(companies.findById(j.getCompany().getId()).orElseThrow());return jobs.save(j);}
}
