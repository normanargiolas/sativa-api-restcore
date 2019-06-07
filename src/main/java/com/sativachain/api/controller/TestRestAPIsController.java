package com.sativachain.api.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sativachain.api.dto.WelcomeDto;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TestRestAPIsController {

	@GetMapping(path = "/api/welcome/{name}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public WelcomeDto welcome(@PathVariable String name) {
		return new WelcomeDto(String.format("Benvenuto, %s", name));
	}

	@GetMapping("/api/test/user")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String userAccess() {
		return ">>> User Contents!";
	}

	@GetMapping("/api/test/pm")
	@PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
	public String projectManagementAccess() {
		return ">>> Board Management Project";
	}
	
	@GetMapping("/api/test/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return ">>> Admin Contents";
	}
}
