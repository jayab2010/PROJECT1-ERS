package com.revature.services;

import com.revature.dao.Ireimbursement;
import com.revature.dao.Iuser;
import com.revature.models.User;

public class UserService {

    private Iuser ud;


    public UserService(Iuser ud, Ireimbursement rd) {
        this.ud = ud;

    }


    public User loginUser(String email, String password) {
        //Try to see if that user exists in the database
        User u = ud.readUserByEmail(email);

        if (u != null) {
            if (password.equals(u.getPassword())) {
                //This is out success
                return u;
            } else {
                //This means the password did not match
                return null;
            }
        }
        return null;
    }





}
