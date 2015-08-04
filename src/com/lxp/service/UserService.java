package com.lxp.service;

import java.sql.SQLException;

import com.lxp.vo.User;

public interface UserService {
	public User save(User user) throws SQLException;
	public User findByAccount(String account) throws SQLException;
}
