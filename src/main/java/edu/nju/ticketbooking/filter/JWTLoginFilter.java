package edu.nju.ticketbooking.filter;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.nju.ticketbooking.constant.JWTSecret;
import edu.nju.ticketbooking.constant.Role;
import edu.nju.ticketbooking.model.AuthenticationInfo;
import edu.nju.ticketbooking.model.Manager;
import edu.nju.ticketbooking.model.User;
import edu.nju.ticketbooking.model.Venue;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * 生成登录token
 */
public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    private AuthenticationInfo authInfo;

    private Role role;

    public JWTLoginFilter(AuthenticationManager authenticationManager, Role role) {
        this.authenticationManager = authenticationManager;
        this.role = role;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;

        String url = request.getRequestURL().toString();
        if (!url.endsWith("login")) {
            chain.doFilter(req, res);
            return;
        }

        if (request.getHeader("Authorization") != null) {
            // 已经有登录token，跳过
            chain.doFilter(req, res);
            return;
        }

        Object info;
        if ((info = req.getAttribute("authInfo")) != null) {
            // 登录信息已由前面的filter读取并往后传递
            if (info.getClass() == AuthenticationInfo.class) {
                authInfo = (AuthenticationInfo) info;
            }
        } else {
            try {
                authInfo = new ObjectMapper().readValue(req.getInputStream(), AuthenticationInfo.class);
                req.setAttribute("authInfo", authInfo);
            } catch (JsonMappingException e) {
                req.setAttribute("authInfo", "No Auth");
            }
        }

        // 只校验自己对应角色的输入，否则跳过
        if (authInfo != null && this.role == authInfo.getRole()) {
            super.doFilter(req, res, chain);
        } else {
            chain.doFilter(req, res);
        }
    }

    // 接收并解析用户凭证
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) {
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authInfo.getKey(),
                        authInfo.getPassword(),
                        new ArrayList<>()
                )
        );
    }

    // 用户成功登录后，生成token
    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        Object principal = auth.getPrincipal();
        JwtBuilder builder = Jwts.builder()
                .setSubject(role.name());
        addId(builder, principal);
        String token = builder.setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000))
                .signWith(SignatureAlgorithm.HS512, JWTSecret.SECRET)
                .compact();
        res.addHeader("Authorization", "Bearer " + token);
    }

    private void addId(JwtBuilder builder, Object principal) {
        int id = 0;
        if (principal.getClass() == User.class) {
            User user = (User) principal;
            id = user.getUserId();
        } else if (principal.getClass() == Venue.class) {
            Venue venue = (Venue) principal;
            id = venue.getVenueId();
        } else if (principal.getClass() == Manager.class) {
            Manager manager = (Manager) principal;
            id = manager.getManagerId();
        }
        builder.claim("id", id);
    }

}
