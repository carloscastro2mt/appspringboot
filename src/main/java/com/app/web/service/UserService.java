package com.app.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.model.User;
import com.app.web.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> sObtenerTodos() {
		return userRepository.obtenerTodos();
	}
	
	public Optional<User> sObtenerUsuario(int id) {
		return userRepository.obtenerUsuario(id);
	}
	
	public User sRegistrar(User user) {
		if(user.getId() == null) {
			if(userRepository.obtenerMail(user.getUseremail()).isEmpty()) {
				System.out.println("===> save");
				return userRepository.save(user);
			}
			else {
				return user;
			}
		}
		return user;
	}
	
	public boolean sValidarEmail(String email) {
		Optional<User> usuario = userRepository.obtenerMail(email);
		if(usuario.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	
	public User sAutenticarUsuario(String email, String password) {
		Optional<User> usuario = userRepository.autenticarUsuario(email, password);
		if(usuario.isEmpty()) {
			return new User(email, password, "NO DEFINIDO");
		}else {
			return usuario.get();
		}
	}
}
