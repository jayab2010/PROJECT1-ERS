package com.revature.dao;


import com.revature.models.User;
import com.revature.utils.ConnectionSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class userJDBC implements Iuser{


    public ConnectionSingleton cs = ConnectionSingleton.getConnectionSingleton();

    @Override
    public void createUser(User u) {

        //To create a user, we must get our connection, create a statement, and execute said statement
        Connection c = cs.getConnection();

        String sql = "insert into users (user_id, first_name, last_name, email, password) values " +
                "(" +u. getUser_id() + ",'" + u.getFirst_name() +"','" + u.getLast_name() + "','" + u.getEmail() +"','" + u.getPassword() + "')";

        try {
            Statement s = c.createStatement();
            s.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<User> readAllUsers() {
        return null;
    }

    @Override
    public User readUserByEmail(String email) {

        Connection c = cs.getConnection();
        String sql ="SELECT * FROM users WHERE email = ?";

        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            User loggedIn = null;
            while(rs.next()){
                loggedIn = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }

            return loggedIn;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User readUserById(int id){
        Connection c = cs.getConnection();
        String sql ="SELECT * FROM users WHERE user_id = ?";

        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            User loggedIn = null;
            while(rs.next()){
                loggedIn = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }

            return loggedIn;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User updateUser(User u) {

        Connection c = cs.getConnection();
        String sql = "UPDATE users " +
                "SET first_name = ?, " + //index 1
                "last_name = ?, " + //index 2
                "email = ?, " + //index 3
                "password = ? " + //index 4s
                "WHERE user_id = ?"; //index 5

        try{
            PreparedStatement p = c.prepareStatement(sql);

            p.setString(1, u.getFirst_name());
            p.setString(2, u.getLast_name());
            p.setString(3, u.getEmail());
            p.setString(4, u.getPassword());
            p.setInt(5, u.getUser_id());

            p.execute();

            return u;

        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteUser(User u) {
        Connection c = cs.getConnection();

        String sql = "DELETE FROM users WHERE user_id = ?";

        try{
            PreparedStatement p = c.prepareStatement(sql);

            p.setInt(1, u.getUser_id());

            p.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}

