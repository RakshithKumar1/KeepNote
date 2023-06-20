package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo repo;
	
	@Override
	public User createAnUser(User user) {

		return repo.save(user);
	}
	

	@Override
	public User updateUser(int userId, User user) {
		
		User u = repo.findById(userId).get();
		if((user.getUserName()!=null) && !"".equalsIgnoreCase(user.getUserName())) {
			u.setUserName(user.getUserName());
		}
		
		if((user.getUserPassword()!=null) && !"".equalsIgnoreCase(user.getUserPassword())){
			u.setUserPassword(user.getUserPassword());
		}
		
		if((user.getUserMobile()!=null && !"".equalsIgnoreCase(user.getUserMobile()))) {
			u.setUserMobile(user.getUserMobile());
		}
		
		return repo.save(u);
	}

	@Override
	public User retrieveAnUser(int userId) {

		return repo.findById(userId).get();
	}

	@Override
	public void deleteUser(int userId) {
		
		final boolean existsOrNot = repo.existsById(userId);
		if(existsOrNot) {
			repo.delete(read(userId));
		}
		

	}
	public User read(int userId) {
		User resutl = null;
		Optional<User> temp = repo.findById(userId);
		if(temp.isPresent()) {
			resutl = repo.findById(userId).get();
		}
		return resutl;
	}



	@Override
	public User authenticateUser(String userName, String userPassword){
		final Optional<User> optionalUser = this.repo.findByUserNameAndPassword(userName, userPassword);
		if(optionalUser.isEmpty()) {
			//exception
		}
		return optionalUser.get();
		
	}

	


	

	
}
