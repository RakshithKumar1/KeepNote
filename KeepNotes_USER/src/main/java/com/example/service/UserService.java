package com.example.service;
import com.example.model.User;


public interface UserService {
	
	public User createAnUser(User user);
    public User authenticateUser(String userName,String userPassword);
	public User updateUser(int userId, User user);
	public User retrieveAnUser(int userId);
	public void deleteUser(int userId);

}
