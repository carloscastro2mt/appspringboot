package com.app.web.repository.crud;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.app.web.model.User;

public interface UserCrudRepository extends CrudRepository<User, Integer> {
	Optional<User> findByUseremail(String useremail);
	Optional<User> findByUseremailAndUserpassword(String useremail, String Userpassword);
}
