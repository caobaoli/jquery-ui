package com.lxp.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.lxp.dao.BaseDao;
import com.lxp.dao.UserDao;
import com.lxp.vo.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	public User save(User user) throws SQLException {
		String sql = "INSERT INTO USER(ID, ACCOUNT, PASS, EMAIL, SEX, BIRTHDAY) VALUE(?, ?, ?, ?, ?, ?)";
		super.executeUpdate(sql, user.getId(), user.getAccount(), user.getPass(), user.getEmail(), user.getSex(), user.getDate());
		return user;
	}

	public User findByAccount(String account) throws SQLException {
		String sql = "SELECT ID, ACCOUNT, PASS, EMAIL, SEX, BIRTHDAY FROM USER u WHERE u.ACCOUNT = ? ";
		List<Map<String, Object>> list = super.executeQuery(sql, account);
		User user = null;
		if(!list.isEmpty()) {
			Map<String, Object> record = list.get(0);
			user = new User();
			user.setId((String)record.get("ID"));
			user.setAccount((String)record.get("ACCOUNT"));
			user.setPass((String)record.get("PASS"));
			user.setEmail((String)record.get("EMAIL"));
			user.setSex((String)record.get("SEX"));
			user.setDate((String)record.get("BIRTHDAY"));
			
		}
		return user;
	}

}
