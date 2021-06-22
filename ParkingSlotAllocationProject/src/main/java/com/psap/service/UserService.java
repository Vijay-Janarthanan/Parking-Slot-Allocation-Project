package com.psap.service;

import org.springframework.stereotype.Service;
import com.psap.exceptions.DuplicateUserException;
import com.psap.exceptions.InvalidLoginCredintialException;
import com.psap.exceptions.NoSuchUserException;
import com.psap.model.Login;
import com.psap.model.User;

@Service
public interface UserService {
	public boolean registerUser(User user) throws DuplicateUserException;
	public boolean login(Login login) throws InvalidLoginCredintialException;
	public User findUserProfileById(long userId) throws NoSuchUserException;
	public User findUserProfileByEmail(String email) throws NoSuchUserException;
	public boolean deleteUserById(long userId) throws NoSuchUserException;
	public void forgotPassword(String loginId) throws NoSuchUserException;
	public void forgotLoginId(String email) throws NoSuchUserException;
}
