package com.phalguni.jobportal.repository;
import com.phalguni.jobportal.entity.Job; import org.springframework.data.jpa.repository.*; import org.springframework.data.repository.query.Param; import java.util.*;
public interface JobRepository extends JpaRepository<Job,Long>{
 @Query("select j from Job j where j.active=true and (lower(j.title) like lower(concat('%',:q,'%')) or lower(j.skills) like lower(concat('%',:q,'%')) or lower(j.location) like lower(concat('%',:q,'%')))")
 List<Job> search(@Param("q") String q);
 long countByActiveTrue();
}
