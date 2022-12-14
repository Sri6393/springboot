package com.lms.userservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.userservice.entity.Users;
import com.lms.userservice.repository.UserRepository;
import com.lms.userservice.service.NextSequenceService;



@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserRepository repository;
	
	
	@Autowired
	private NextSequenceService nextSequenceService;

	@PostMapping("/save")
	public String saveuser(@RequestBody Users user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		user.setId(nextSequenceService.getNextSequence("customSequences"));
		repository.save(user);
		return "Added user with id : " + user.getId();
	}

	@GetMapping("/findAllusers")
	public List<Users> getusers() {
		return repository.findAll();
	}

	@GetMapping("/findAllusers/{id}")
	public Optional<Users> getuser(@PathVariable int id) {
		return repository.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteuser(@PathVariable int id) {
		repository.deleteById(id);
		return "user deleted with id : " + id;
	}

}
