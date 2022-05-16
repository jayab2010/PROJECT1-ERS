package com.revature.dao;

import com.revature.models.User;

import java.util.List;


public interface Iuser {


    //Create
    public void createUser(User u);

    //Read
    public List<User> readAllUsers();

    //Read
    public User readUserByEmail(String email);

    //Read
    public User readUserById(int id);

    //Update
    public User updateUser(User u);

    //Delete
    public void deleteUser(User u);



}
