package com.phalguni.jobportal.controller;
import com.phalguni.jobportal.dto.*; import com.phalguni.jobportal.entity.*; import com.phalguni.jobportal.repository.*; import lombok.RequiredArgsConstructor; import org.springframework.security.core.Authentication; import org.springframework.web.bind.annotation.*; import java.time.LocalDateTime; import java.util.*;
@RestController @RequestMapping("/api/applications") @RequiredArgsConstructor public class ApplicationController{
 private final ApplicationRepository apps;private final JobRepository jobs;private final UserRepository users;
 @PostMapping public JobApplication apply(@RequestBody ApplicationRequest r,Authentication a){var u=users.findByUsername(a.getName()).orElseThrow();if(u.getRole()!=Role.JOB_SEEKER)throw new RuntimeException("Only job seekers can apply");if(apps.existsByJobIdAndApplicantId(r.jobId(),u.getId()))throw new RuntimeException("You already applied to this job");var j=jobs.findById(r.jobId()).orElseThrow();return apps.save(JobApplication.builder().job(j).applicant(u).resumeUrl(r.resumeUrl()).coverLetter(r.coverLetter()).status(ApplicationStatus.APPLIED).appliedAt(LocalDateTime.now()).build());}
 @GetMapping("/mine") public List<JobApplication> mine(Authentication a){var u=users.findByUsername(a.getName()).orElseThrow();return apps.findByApplicantIdOrderByAppliedAtDesc(u.getId());}
 @GetMapping("/recruiter") public List<JobApplication> recruiter(Authentication a){var u=users.findByUsername(a.getName()).orElseThrow();return apps.findByJobPostedByIdOrderByAppliedAtDesc(u.getId());}
}
