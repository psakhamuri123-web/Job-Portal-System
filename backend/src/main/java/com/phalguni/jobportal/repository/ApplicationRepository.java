package com.phalguni.jobportal.repository;
import com.phalguni.jobportal.entity.JobApplication; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface ApplicationRepository extends JpaRepository<JobApplication,Long>{
 List<JobApplication> findByApplicantIdOrderByAppliedAtDesc(Long id);
 List<JobApplication> findByJobPostedByIdOrderByAppliedAtDesc(Long id);
 boolean existsByJobIdAndApplicantId(Long jobId,Long applicantId);
}
