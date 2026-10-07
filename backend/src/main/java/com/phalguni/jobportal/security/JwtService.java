package com.phalguni.jobportal.security;
import io.jsonwebtoken.*; import io.jsonwebtoken.security.Keys; import org.springframework.beans.factory.annotation.Value; import org.springframework.security.core.userdetails.UserDetails; import org.springframework.stereotype.Service;
import javax.crypto.SecretKey; import java.nio.charset.StandardCharsets; import java.util.Date;
@Service public class JwtService {
 private final SecretKey key; private final long exp;
 public JwtService(@Value("${app.jwt.secret}") String s,@Value("${app.jwt.expiration}") long e){key=Keys.hmacShaKeyFor(s.getBytes(StandardCharsets.UTF_8));exp=e;}
 public String generate(UserDetails u){return Jwts.builder().subject(u.getUsername()).issuedAt(new Date()).expiration(new Date(System.currentTimeMillis()+exp)).signWith(key).compact();}
 public String username(String t){return Jwts.parser().verifyWith(key).build().parseSignedClaims(t).getPayload().getSubject();}
 public boolean valid(String t,UserDetails u){try{return username(t).equals(u.getUsername())&&Jwts.parser().verifyWith(key).build().parseSignedClaims(t).getPayload().getExpiration().after(new Date());}catch(Exception e){return false;}}
}
