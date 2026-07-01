package com.cinebokk.service;

import java.util.Random;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cinebokk.DTO.AuthRequest;
import com.cinebokk.DTO.AuthResponse;
import com.cinebokk.entity.User;
import com.cinebokk.repository.UserRepository;
import com.cinebokk.security.JwtUtil;

@Service
public class AuthService {

	private final UserRepository repository;

	private final JwtUtil jwtUtil;

	private final PasswordEncoder passwordEncoder;

	public AuthService(UserRepository repository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {

		this.repository = repository;

		this.jwtUtil = jwtUtil;

		this.passwordEncoder = passwordEncoder;

	}

	// REGISTER

	public User register(AuthRequest request) {

		if (repository.findByEmail(request.getEmail())

				.isPresent()

		) {

			throw new RuntimeException("Email already exists");

		}

		User user = new User();

		user.setName(request.getName());

		user.setEmail(request.getEmail());

		user.setPhone(request.getPhone());

		user.setPassword(

				passwordEncoder.encode(request.getPassword())

		);

		return repository.save(user);

	}

	// LOGIN

	public AuthResponse login(AuthRequest request) {

		User user = repository.findByEmail(request.getEmail())

				.orElseThrow(() -> new RuntimeException("User not found"));

		if (

		!passwordEncoder.matches(request.getPassword(), user.getPassword())

		) {

			throw new RuntimeException("Invalid password");

		}

		String token = jwtUtil.generateToken(user.getEmail());

		return new AuthResponse(token, user);

	}

	// CHANGE PASSWORD

	public String changePassword(AuthRequest req) {

		User user = repository.findByEmail(req.getEmail())

				.orElseThrow();

		if (

		!passwordEncoder.matches(req.getOldPassword(), user.getPassword())

		) {

			return "Wrong password";

		}

		user.setPassword(

				passwordEncoder.encode(req.getNewPassword())

		);

		repository.save(user);

		return "Password changed";

	}

	// SEND OTP

	public String sendOtp(AuthRequest req) {

		User user = repository.findByEmail(req.getEmail())

				.orElseThrow();

		String otp = String.valueOf(100000 + new Random().nextInt(900000));

		user.setOtp(otp);

		repository.save(user);

		System.out.println("OTP = " + otp);

		return "OTP Sent";

	}

	// FORGOT PASSWORD

	public String forgotPassword(AuthRequest req) {

		User user = repository.findByEmail(req.getEmail())

				.orElseThrow();

		if (!user.getOtp().equals(req.getOtp())) {

			return "Invalid OTP";

		}

		user.setPassword(

				passwordEncoder.encode(req.getNewPassword())

		);

		user.setOtp(null);

		repository.save(user);

		return "Password Updated";

	}

}