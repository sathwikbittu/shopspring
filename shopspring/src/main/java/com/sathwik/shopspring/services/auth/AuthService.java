package com.sathwik.shopspring.services.auth;

import com.sathwik.shopspring.dto.SignupRequest;
import com.sathwik.shopspring.dto.UserDto;

public interface AuthService {
	UserDto createUser(SignupRequest signupRequest);

	Boolean hasUserWithEmail(String email);

	void createAdminAccount();
}
