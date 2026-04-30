package com.example.Assignment15.utilities;
import io.jsonwebtoken.*;
import com.example.Assignment15.model.User;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private final String secreT="iamsherajussalehintryingmybesttowriteasecrectkeywithoutusingkebabcaseorspacebuttonidontevenknowifiamspellingright";
    public String generateToken(User user) {
        //return token
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("role",user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60))//1hr
                .signWith(SignatureAlgorithm.HS256,secreT)
                .compact();

    }
    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(secreT)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    public boolean validateToken(String token) {
        try{
            Jwts.parser()
                    .setSigningKey(secreT)
                    .parseClaimsJws(token);
            return true;
        }catch(Exception e){
            return false;
        }
    }


}
