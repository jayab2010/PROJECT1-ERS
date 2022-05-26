package com.revature.dao;

import com.revature.models.User;

import java.sql.SQLException;
import java.util.List;


public interface Iuser {


    //Create
    public void createUser(User u);

    //Read
    public User readAllUsers(int id);



    public User readUserByEmail(String email);





    //Read
    //public User readUserById(int id);

    //Update
    public User updateUser(User u);

    //Delete
    //public void deleteUser(User u);



}
