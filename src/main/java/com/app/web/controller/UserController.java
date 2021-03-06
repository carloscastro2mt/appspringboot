package com.app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.web.model.User;
import com.app.web.service.UserService;

@RestController
@RequestMapping("/api/user")
//@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/all")
	public List<User> cObtenerTodos() {
		return userService.sObtenerTodos();
	}
	
	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	public User cRegistrarUsuario(@RequestBody User user){
		return userService.sRegistrar(user);
	}
	
	@GetMapping("/{email}/{password}")
	public User cAutenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
		return userService.sAutenticarUsuario(email, password);
	}
	
	@GetMapping("/{email}")
	public boolean cValidarEmail(@PathVariable("email") String email) {
		return userService.sValidarEmail(email);
		
	}

}
