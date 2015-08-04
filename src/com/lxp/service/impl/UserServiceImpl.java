package com.lxp.service.impl;

import java.sql.SQLException;

import com.lxp.dao.UserDao;
import com.lxp.dao.impl.UserDaoImpl;
import com.lxp.service.UserService;
import com.lxp.vo.User;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	public User save(User user) throws SQLException {
		return userDao.save(user);
	}

	public User findByAccount(String account) throws SQLException {
		return userDao.findByAccount(account);
	}

}
