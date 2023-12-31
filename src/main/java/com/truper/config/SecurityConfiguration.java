package com.truper.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.truper.jwt.filter.JwtFilter;
import com.truper.jwt.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
		@Autowired
		private UserService userService;
		
		@Autowired
		private JwtFilter jwtFilter;
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception{
			auth.userDetailsService(userService);
		}
		
		@Override
		@Bean
		public AuthenticationManager authenticationManagerBean() throws Exception{
			return super.authenticationManager();
		}
		
		@Override
		protected void configure(HttpSecurity httpSecurity) throws Exception{
			httpSecurity.csrf()
				.disable()
				.authorizeRequests()
				.antMatchers("/authenticate")
				.permitAll()
				.antMatchers("/h2-console/**")
				.permitAll()
				.anyRequest()
				.authenticated()				
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			
			httpSecurity.headers().frameOptions().sameOrigin();		
			httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		}
	
}
