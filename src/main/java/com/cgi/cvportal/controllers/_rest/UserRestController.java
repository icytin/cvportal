package com.cgi.cvportal.controllers._rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.cvportal.controllers._rest.exceptionhandler.CustomMethodArgumentNotValidException;
import com.cgi.cvportal.model.User;
import com.cgi.cvportal.model.UserDao;

@RestController
public class UserRestController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/rest/users", method = RequestMethod.GET)
	public Iterable<User> list() {
		return userDao.findAll();
	}

	@RequestMapping(value = "/rest/users", method = RequestMethod.POST)
	public ResponseEntity<User> create(@Valid @RequestBody User user) {
		userDao.save(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/rest/users/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) throws MethodArgumentNotValidException{
		if (!userDao.exists(id))
			throw new CustomMethodArgumentNotValidException(id, "id", "användare med id ("+ id +") saknas i databasen");
		
		userDao.delete(id);
	}

	@RequestMapping(value = "/rest/users", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user) throws MethodArgumentNotValidException {
		if (user.getId() == null || user.getId() < 1) 
			throw new CustomMethodArgumentNotValidException(user, "id", "användarobjektet saknar id");
		
		User userToUpdate = userDao.findOne(user.getId());
		
		if (userToUpdate==null) 
			throw new CustomMethodArgumentNotValidException(user, "id", "användare med id ("+ user.getId() +") saknas i databasen");
		
		//Update updateables
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setName(user.getName());
		
		userDao.save(userToUpdate);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/rest/users-by-email", method = RequestMethod.GET)
	public ResponseEntity<User> getByEmail(String email) {
		User user = userDao.findByEmail(email);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}