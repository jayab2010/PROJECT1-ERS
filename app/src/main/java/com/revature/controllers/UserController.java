package com.revature.controllers;



//import com.revature.models.LoginObject;
//import com.revature.models.RegisterObject;
import com.revature.models.User;
//import com.revature.services.PostService;
import com.revature.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Handler;

public class UserController {

    private UserService us;

    private ObjectMapper om;

    public UserController(UserService us){
        this.us = us;
        this.om = new ObjectMapper();
    }


     public Handler handleLogin = (ctx) -> {
        LoginObject lo = om.readValue(ctx.body(), LoginObject.class);

        User u = us.loginUser(lo.email, lo.password);

         ctx.req.getSession().invalidate();
         ctx.result("User logged In");
/*
         if(u == null){
             ctx.status(403);
             ctx.result("Username or password was incorrect");
         }
         else{
             ctx.req.getSession().setAttribute("loggedIn: ", u.getEmail());
             ctx.req.getSession().setAttribute("id", "" + u.getUser_id());
             ctx.result(om.writeValueAsString(u.getFirst_name() +" "+ u.getLast_name() + " has logged in"));
         }

 */
     };


    public Handler handleLogout = (ctx) -> {
        ctx.req.getSession().invalidate();
        ctx.result("User logged out");
    };

/*
    public Handler handleUpdateUser = (ctx) -> {
        User u = om.readValue(ctx.body(), User.class);

        System.out.println(u);

        ctx.result(om.writeValueAsString(us.updateUserInfo(u)));
    };

    public Handler handleDeleteUser = (ctx) -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        User u = new User();
        u.setUser_id(id);
        us.deleteUser(u);
        ctx.result("User deleted");
    };
/*
    public Handler handleFollowUser = (ctx) -> {
        if(ctx.req.getSession().getAttribute("id") == null){
            ctx.status(401);
            ctx.result("You must be logged in to follow another user");
        } else {
            int userId = Integer.parseInt((String) ctx.req.getSession().getAttribute("id"));

            int followingId = Integer.parseInt(ctx.pathParam("id"));

            //us.createFollowingRelationship(followingId, userId);

            //ctx.result("User followed");
        }
    };

/*
    public Handler handleFullUserObject = (ctx) -> {

        if(ctx.req.getSession().getAttribute("loggedIn") == null){
            ctx.status(401);
            ctx.result("You must be logged in to follow another user");
        } else {
            String email = (String) ctx.req.getSession().getAttribute("loggedIn");
            User current = us.populateUserObject(email);
            ctx.result(om.writeValueAsString(current));
        }
         */

        //int userId = Integer.parseInt(ctx.pathParam("id"));

        //User u = us.populateUserObject(userId);

        //ctx.result(om.writeValueAsString(u));

    //Create the implemenation for your handlers inside of Controller classes to clean up your main method
    /*public Handler handleRegister = (ctx) -> {
        RegisterObject ro = om.readValue(ctx.body(), RegisterObject.class);

        System.out.println(ro);

        us.registerUser(ro.first, ro.last, ro.email, ro.password);
        ctx.status(201);
        ctx.result("Create user");
    };
*/


}

