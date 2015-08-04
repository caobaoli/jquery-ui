package com.lxp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseDao {
	private static final String DRIVERCLASS="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/zhihu?characterEncoding=utf8";
	private static final String UID="root";
	private static final String PWD="root";
	private Connection conn=null;
	static{
		try {
			Class.forName(DRIVERCLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 打开连接
	 * @throws SQLException 
	 */
	protected void openConnection() throws SQLException {
		if(conn == null || conn.isClosed()) {
			conn = DriverManager.getConnection(URL, UID, PWD);
		}
	}
	
	/**
	 * 关闭连接
	 * @throws SQLException 
	 */
	protected void closeConnection() throws SQLException {
		if(conn != null && !conn.isClosed()) {
			conn = null;
		}
	}
	
	private PreparedStatement buildPreparedStatement(String sql, boolean returnGeneratedKeys, Object ... params) throws SQLException {
		openConnection();
		PreparedStatement pstat = returnGeneratedKeys?conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS):conn.prepareCall(sql);
		for(int i = 0; i < (params==null?0:params.length); i++) {
			pstat.setObject((i + 1), params[i]);
		}
		return pstat;
	}
	
	/**
	 * 执行查询
	 * 把把一条记录放入map<key, values>中，在将map放入list中
	 * @throws SQLException 
	 */
	protected List<Map<String, Object>> executeQuery(String sql, Object ... params) throws SQLException {
		PreparedStatement pstat = this.buildPreparedStatement(sql, false, params);
		ResultSet rs = pstat.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		while(rs.next()) {
			Map<String, Object> record = new HashMap<String, Object>();
			for(int i = 0; i < columnCount; i++) {
				record.put(rsmd.getColumnLabel(i + 1), rs.getObject(i + 1));
			}
			list.add(record);
		}
		
		return list;
	}
	
	/**
	 * 增删改
	 * @throws SQLException 
	 */
	protected Integer executeUpdate(String sql, Object ... params) throws SQLException {
		return this.buildPreparedStatement(sql, false, params).executeUpdate();
	}
	/**
	 * 执行insert语句后获取自动增长值
	 * @throws SQLException 
	 */
	protected Long executeInsertAndGetPk(String sql, Object ... params) throws SQLException {
		PreparedStatement pstat = this.buildPreparedStatement(sql, true, params);
		pstat.executeUpdate();
		ResultSet rs = pstat.getGeneratedKeys();
		Long result = null;
		if(rs.next()) {
			result = rs.getLong(1);
		}
		return result;
	}
}

