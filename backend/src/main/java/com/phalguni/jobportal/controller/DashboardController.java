package com.phalguni.jobportal.controller;
import com.phalguni.jobportal.repository.*; import lombok.RequiredArgsConstructor; import org.springframework.web.bind.annotation.*; import java.util.Map;
@RestController @RequestMapping("/api/dashboard") @RequiredArgsConstructor public class DashboardController{
 private final JobRepository jobs;private final CompanyRepository companies;private final ApplicationRepository apps;private final UserRepository users;
 @GetMapping("/summary") public Map<String,Object> summary(){return Map.of("jobs",jobs.countByActiveTrue(),"companies",companies.count(),"applications",apps.count(),"users",users.count());}
}
