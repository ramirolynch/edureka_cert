package myCertification.bank.services;

import org.springframework.beans.factory.annotation.Autowired;

import myCertification.bank.dao.UserDao;
import myCertification.bank.dto.User;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;
	
	public User findUserById(Long id) {
		return dao.findUserById(id);
	}

}
