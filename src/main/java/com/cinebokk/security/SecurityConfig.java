//package com.cinebokk.security;
//
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//	@Bean
//	SecurityFilterChain security(HttpSecurity http) throws Exception {
//
//		http
//
//				.csrf(csrf -> csrf.disable())
//
//				.cors(Customizer.withDefaults())
//				
//				.formLogin(
//						form -> form.disable()
//						)
//
//						.httpBasic(
//						basic -> basic.disable()
//						)
//
//				.authorizeHttpRequests(
//
//						auth -> auth
//
//								.requestMatchers("/api/auth/**",
//										
//										"/api/movies/**",
//										"/api/bookings/**",
//										"/api/payments/**",
//										"/api/offers/**",
//										"/api/events/**",
//										"/api/theaters/**",
//										"/api/users/**"
//										)
//
//								.permitAll()
//
//								.anyRequest()
//
//								.authenticated()
//
//				);
//
//		return http.build();
//
//	}
//
//	@Bean
//	PasswordEncoder passwordEncoder() {
//
//		return new BCryptPasswordEncoder();
//
//	}
//
//}


package com.cinebokk.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain security(
			HttpSecurity http
	) throws Exception {

		http

		.csrf(
				csrf -> csrf.disable()
		)

		.cors(
				Customizer.withDefaults()
		)

		.formLogin(
				form -> form.disable()
		)

		.httpBasic(
				basic -> basic.disable()
		)

		.authorizeHttpRequests(

				auth -> auth

				.requestMatchers(
						HttpMethod.GET,
						"/api/**"
				)

				.permitAll()

				.requestMatchers(
						HttpMethod.POST,
						"/api/**"
				)

				.permitAll()

				.requestMatchers(
						HttpMethod.PUT,
						"/api/**"
				)

				.permitAll()

				.requestMatchers(
						HttpMethod.DELETE,
						"/api/**"
				)

				.permitAll()

				.anyRequest()

				.permitAll()

		);

		return http.build();

	}

	@Bean
	PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();

	}

}
