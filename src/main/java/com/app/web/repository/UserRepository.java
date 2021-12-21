package com.app.web.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.web.model.User;
import com.app.web.repository.crud.UserCrudRepository;

@Repository
public class UserRepository {
	
	@Autowired
	private UserCrudRepository userCrudRepository;
	
	public List<User> obtenerTodos() {
		return (List<User>) userCrudRepository.findAll();
	}
	
	public Optional<User> obtenerUsuario(int id) {
		return userCrudRepository.findById(id);
	}
	
	public Optional<User> obtenerMail(String email) {
		return userCrudRepository.findByUseremail(email);
	}
	
	public Optional<User> autenticarUsuario(String email, String password) {
		return userCrudRepository.findByUseremailAndUserpassword(email, password);
	}
	
	public User save(User user) {
        return userCrudRepository.save(user);
    }
	
}
