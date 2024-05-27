package thanhnt.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import thanhnt.web.services.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private CustomUserDetailService customUserDetailService;
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()).authorizeHttpRequests((auth) ->auth.requestMatchers("/*","/file").permitAll()
//				.requestMatchers("/user-login/**").hasAnyAuthority("USER","ADMIN")
				.requestMatchers("/admin/**").hasAuthority("ADMIN").anyRequest().authenticated()).formLogin(login ->login
						.loginPage("/login").loginProcessingUrl("/login").usernameParameter("username").passwordParameter("password")
						.defaultSuccessUrl("/admin",true)).logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login"));
	return http.build();
	}
	
	@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		return (web)->web.ignoring().requestMatchers("/static/**","/assets/**","/styleadmin/**");
	}
	
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/upload/**")
//                .addResourceLocations("file:./upload/");
//    }
}
