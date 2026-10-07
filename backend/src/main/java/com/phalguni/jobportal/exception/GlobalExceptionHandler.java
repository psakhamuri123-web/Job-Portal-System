package com.phalguni.jobportal.exception;
import org.springframework.http.*;import org.springframework.web.bind.annotation.*;import java.util.Map;
@RestControllerAdvice public class GlobalExceptionHandler{@ExceptionHandler(RuntimeException.class) ResponseEntity<?> error(RuntimeException e){return ResponseEntity.badRequest().body(Map.of("message",e.getMessage()==null?"Request failed":e.getMessage()));}}
