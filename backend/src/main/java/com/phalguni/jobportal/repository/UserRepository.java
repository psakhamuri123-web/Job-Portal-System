package com.phalguni.jobportal.repository;
import com.phalguni.jobportal.entity.AppUser; import org.springframework.data.jpa.repository.JpaRepository; import java.util.Optional;
public interface UserRepository extends JpaRepository<AppUser,Long>{Optional<AppUser> findByUsername(String username);}
