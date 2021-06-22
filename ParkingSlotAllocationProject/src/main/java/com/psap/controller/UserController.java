package com.psap.controller;

import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.psap.exceptions.DuplicateUserException;
import com.psap.exceptions.NoSuchUserException;
import com.psap.model.User;
import com.psap.repository.LoginRepository;
import com.psap.repository.UserRepository;
import com.psap.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userrepo;
	@Autowired
	LoginRepository loginrepo;
	@Autowired
	UserService uservice;

	// Find User by login Id

	@GetMapping("/finduser/{uid}")
	public ResponseEntity<?> getUserProfileById(@PathVariable("uid") @RequestBody long userId)
			throws NoSuchUserException {
		Optional<User> opt = userrepo.findById(userId);
		if (opt.isPresent())
			return new ResponseEntity<User>(opt.get(), HttpStatus.OK);
		// throw new NoSuchUserException("User with Id " + userId + "Not Found");
		return new ResponseEntity<String>("User with Id " + userId + "Not Found", HttpStatus.CREATED);

	}

	// User to register

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user) throws DuplicateUserException {
		Optional<User> opt = userrepo.findById(user.getUserId());
		if (opt.isPresent())
			throw new DuplicateUserException("User with Id " + user.getUserId() + "Already exists");
		userrepo.save(user);
		return new ResponseEntity<String>("User Registered Sucessfully", HttpStatus.CREATED);
	}

	// User to delete

	@DeleteMapping("/delete/{uid}")
	public ResponseEntity<?> deleteUser(@PathVariable("uid") @RequestBody long userId) throws NoSuchUserException {
		Optional<User> opt = userrepo.findById(userId);
		if (!opt.isPresent()) {
			throw new NoSuchUserException("User with Id is Not Active");
		}
		uservice.deleteUserById(userId);
		return new ResponseEntity<String>("User deleted Succesfully", HttpStatus.ACCEPTED);
	}

}
