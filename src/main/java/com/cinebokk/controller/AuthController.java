//package com.cinebokk.controller;
//
//
//
//import org.springframework.web.bind.annotation.*;
//
//import com.cinebokk.DTO.AuthRequest;
//import com.cinebokk.entity.User;
//import com.cinebokk.service.AuthService;
//
//@RestController
//
//@RequestMapping("/api/auth")
//
//@CrossOrigin(origins = "http://localhost:5173")
//
//public class AuthController {
//
//	private final AuthService service;
//
//	public AuthController(AuthService service) {
//		this.service = service;
//	}
//
//	@PostMapping("/register")
//
//	public User register(@RequestBody AuthRequest req) {
//		return service.register(req);
//	}
//
//	@PostMapping("/login")
//
//	public User login(@RequestBody AuthRequest req) {
//		return service.login(req);
//	}
//
//	@PostMapping("/change-password")
//
//	public String change(@RequestBody AuthRequest req) {
//		return service.changePassword(req);
//	}
//
//	@PostMapping("/send-otp")
//
//	public String send(@RequestBody AuthRequest req) {
//		return service.sendOtp(req);
//	}
//
//	@PostMapping("/forgot-password")
//
//	public String forgot(@RequestBody AuthRequest req) {
//		return service.forgotPassword(req);
//	}
//
//}

package com.cinebokk.controller;

import org.springframework.web.bind.annotation.*;

import com.cinebokk.DTO.AuthRequest;
import com.cinebokk.DTO.AuthResponse;
import com.cinebokk.entity.User;
import com.cinebokk.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")

public class AuthController {

	private final AuthService service;

	public AuthController(AuthService service) {
		this.service = service;
	}

	@PostMapping("/register")
	public User register(@RequestBody AuthRequest req) {

		return service.register(req);

	}

	@PostMapping("/login")
	public AuthResponse login(@RequestBody AuthRequest req) {

		return service.login(req);

	}

	@PostMapping("/change-password")
	public String change(@RequestBody AuthRequest req) {

		return service.changePassword(req);

	}

	@PostMapping("/send-otp")
	public String send(@RequestBody AuthRequest req) {

		return service.sendOtp(req);

	}

	@PostMapping("/forgot-password")
	public String forgot(@RequestBody AuthRequest req) {

		return service.forgotPassword(req);

	}

}