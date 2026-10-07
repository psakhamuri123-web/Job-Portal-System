# Job Portal System

Full-stack Job Portal System built with Java 17, Spring Boot, Spring Security/JWT, JPA/Hibernate, MySQL and Angular.

## Features
- Candidate and recruiter authentication
- JWT security
- Job browsing and keyword search
- Recruiter job posting
- Candidate applications
- Duplicate-application prevention
- Application status workflow
- Resume URL and cover letter
- Company/job/user/application data model
- Dashboard metrics
- REST APIs
- Docker Compose
- JUnit test

## Demo users
Candidate: `candidate` / `candidate123`
Recruiter: `recruiter` / `recruiter123`

## Run
1. Start MySQL with `docker compose up mysql -d`, or install MySQL and create `job_portal_db`.
2. Backend:
   `cd backend`
   `mvn spring-boot:run`
   API: http://localhost:8081
3. Frontend:
   `cd frontend`
   `npm install`
   `npm start`
   UI: http://localhost:4200

## Resume description
**Job Portal System | Java 17, Spring Boot, Angular, MySQL**
- Developed a full-stack job marketplace using Spring Boot REST APIs, Angular and MySQL for job discovery, recruiter postings and candidate applications.
- Implemented JWT authentication with Spring Security and role-based workflows for job seekers and recruiters.
- Designed JPA/Hibernate relationships for users, companies, jobs and applications and implemented duplicate-application validation.
- Built keyword-based job search and Angular interfaces for job listings, applications and portal metrics.
- Added application status management, validation, exception handling, JUnit testing and Docker Compose support.
