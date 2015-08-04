package com.lxp.dao;

import java.sql.SQLException;

import com.lxp.vo.User;

public interface UserDao {
	public User save(User user) throws SQLException;
	public User findByAccount(String account) throws SQLException;
	
}

