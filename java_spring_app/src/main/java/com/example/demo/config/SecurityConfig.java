package com.example.demo.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
				.formLogin(login -> login
	    		.loginProcessingUrl("/login")			// ログイン処理のパス
	    		.loginPage("/login")					// ログインページの指定
	    		.failureUrl("/login?error")				// ログイン失敗時の遷移先
	    		.usernameParameter("userId")			// ログインページのユーザーID
	    		.passwordParameter("password")			// ログインページのパスワード
	    		.defaultSuccessUrl("/user/list", true)	// 成功後の遷移先
	    		.permitAll()							// ログイン画面は未ログインでもアクセス可能
	    			
	    	).logout(logout -> logout
	    			.logoutSuccessUrl("/login")
	    			
	        ).authorizeHttpRequests(authz -> authz
	                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
	                .requestMatchers("/").permitAll()
	                .requestMatchers("/general").hasRole("GENERAL")
	                .requestMatchers("/admin").hasRole("ADMIN")
	                .anyRequest().authenticated()
	        );
		
		return http.build();
	}
	
}
