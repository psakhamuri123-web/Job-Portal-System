package com.phalguni.jobportal.repository;
import com.phalguni.jobportal.entity.Company; import org.springframework.data.jpa.repository.JpaRepository;
public interface CompanyRepository extends JpaRepository<Company,Long>{}
