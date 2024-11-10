package com.user.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.user.model.User;
public class UserDAO {
	
	private String jdbcURL="jdbc:mysql://localhost:3006/userappdb";
	private String jdbcUsername="root";
	private String jdbcPassword="kamakshi@04";
	
	private static final String INSERT_USER_SQL="INSERT INTO users"+"(username,password,email,country,high_score) VALUES "+"(?,?,?,?,?):";
	private static final String SELECT_USER_BY_ID="SELECT * FROM USERS WHERE ID=?;";
	private static final String SELECT_ALL_USERS="SELECT * FROM USERS;";
	private static final String DELETE_USERS_SQL="DELETE FROM USERS WHERE ID=?;";
	private static final String  UPDATE_USERS_SQL="UPDATE USERS SET USERNAME=?,PASSWORD=?,EMAIL=?,COUNTRY=?,HIGH SCORE=? WHERE ID=?;";
	
	public UserDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Connection getConnection()
	{
		Connection connection=null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return connection;
	}
	
	public void insertUser(User user) 
	{
		UserDAO dao=new UserDAO();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USER_SQL);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getCountry());
			preparedStatement.setLong(5, user.getHigh_score());
			
			preparedStatement.executeUpdate();
			
		}
		catch (Exception e) {
			
		}
	}
	
	public User selectUser(int id) {
		User user=new User();
		UserDAO dao=new UserDAO();
		
		try(Connection connection=dao.getConnection()) {
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_USER_BY_ID);
			preparedStatement.setInt(1,id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) 
			{
				user.setId(id);
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
				user.setCountry(resultSet.getString("email"));
				user.setHigh_score(resultSet.getInt("high_score"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public List<User> selectAllUsers() 
	{
		List<User> users=new ArrayList<User>();
		UserDAO dao=new UserDAO();
		try(Connection connection=dao.getConnection()){
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_USERS);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int id=resultSet.getInt("Id");
				String username=resultSet.getString("username");
				String password=resultSet.getString("password");
				String email=resultSet.getString("email");
				String country=resultSet.getString("country");
				int high_score=resultSet.getInt("high_score");
				
				
				users.add(new User(id,username,password,email,country,high_score));
				
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public boolean deleteUser(int id) {
		boolean status=false;
		UserDAO dao=new UserDAO();
		try(Connection connection=dao.getConnection()){
			PreparedStatement preparedStatement=connection.prepareStatement(DELETE_USERS_SQL);
		    preparedStatement.setInt(1, id);
		    
		    status=preparedStatement.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
}
