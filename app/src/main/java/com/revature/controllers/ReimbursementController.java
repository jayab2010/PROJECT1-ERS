package com.revature.controllers;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.UserService;
import io.javalin.http.Handler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.ReimbursementService;

public class ReimbursementController {
    private ReimbursementService rs;
    private UserService us;
    private ObjectMapper om;

    public ReimbursementController(ReimbursementService rs) {
        this.rs = rs;
        this.om = new ObjectMapper();
    }
    public Handler handleCreateReimbursement = (ctx) ->{
        if(ctx.req.getSession().getAttribute("id") == null){
            ctx.status(401);
            ctx.result("You must be logged in to create a reimbursement ticket");
        }
        else{
            int userID = Integer.parseInt((String) ctx.req.getSession().getAttribute("id"));

            User u = new User();
            u.setUser_id(userID);

            Reimbursement r = om.readValue(ctx.body(), Reimbursement.class);

            rs.createReimbursement(r.getAmount(), r.getDescription(), u.getUser_id(), r.getReimbursement_type());

            ctx.status(201);
            ctx.result("Your ticket has been submitted");
        }
    };

    public Handler handleEmployeeViewPending = (ctx) ->{
        //ctx.header("Access-Control-Expose-Headers", "*");

        if(ctx.req.getSession().getAttribute("id") == null){
            ctx.status(401);
            ctx.result("You must be logged in to view pending tickets");
        }
        else{
            int userID = Integer.parseInt((String) ctx.req.getSession().getAttribute("id"));

            ctx.result(om.writeValueAsString(rs.employeeViewPending(userID)));
        }
    };

    public Handler handleEmployeeViewResolved = (ctx) ->{
        //ctx.header("Access-Control-Expose-Headers", "*");

        if(ctx.req.getSession().getAttribute("id") == null){
            ctx.status(401);
            ctx.result("You must be logged in to view resolved tickets");
        }
        else{
            int userID = Integer.parseInt((String) ctx.req.getSession().getAttribute("id"));

            ctx.result(om.writeValueAsString(rs.employeeViewResolved(userID)));
        }
    };

    public Handler handleManagerApprove = (ctx) ->{
        if(ctx.req.getSession().getAttribute("id") == null){
            ctx.status(403);
            ctx.result("Must be logged in to approve account");
        }
        else{
            int managerID = Integer.parseInt((String) ctx.req.getSession().getAttribute("id"));

            if(managerID !=2 ){
                ctx.status(401);
                ctx.result("Must be manager to approve reimbursement");
            }
            else{
                Reimbursement r = om.readValue(ctx.body(), Reimbursement.class);
                ctx.result(om.writeValueAsString(rs.managerApprove(managerID,r.getReimbursement_id())));
            }

        }
    };
    public Handler handleManagerDeny = (ctx) ->{
        if(ctx.req.getSession().getAttribute("id") == null){
            ctx.status(401);
            ctx.result("You must be logged in to deny ticket");
        }
        else{
            int managerID = Integer.parseInt((String) ctx.req.getSession().getAttribute("id"));

            if(managerID !=2 ){
                ctx.status(401);
                ctx.result("Must be manager to deny reimbursement");
            }
            else{
                Reimbursement r = om.readValue(ctx.body(), Reimbursement.class);

                ctx.result(om.writeValueAsString(rs.managerDeny(managerID,r.getReimbursement_id())));
            }

        }
    };

    public Handler handleManagerAllPending = (ctx) ->{
        if(ctx.req.getSession().getAttribute("id") == null){
            ctx.status(401);
            ctx.result("You must be logged in to view pending tickets");
        }
        else {
            int managerID = Integer.parseInt((String) ctx.req.getSession().getAttribute("id"));

            if (managerID != 2) {
                ctx.status(401);
                ctx.result("Must be manager to view all pending");
            }
            else {
                ctx.result(om.writeValueAsString(rs.managerAllPending()));
            }
        }
    };

    public Handler handleManagerAllResolved = (ctx) ->{
        if(ctx.req.getSession().getAttribute("id") == null){
            ctx.status(401);
            ctx.result("You must be logged in to view resolved tickets");
        }
        else {
            int managerID = Integer.parseInt((String) ctx.req.getSession().getAttribute("id"));

            if (managerID != 2) {
                ctx.status(401);
                ctx.result("Must be manager to view all resolved");
            }
            else {
                ctx.result(om.writeValueAsString(rs.managerAllResolved()));
            }
        }
    };
    public Handler handleManagerByEmployee = (ctx) ->{
        if(ctx.req.getSession().getAttribute("id") == null){
            ctx.status(401);
            ctx.result("You must be logged in to view employee ticket");
        }
        else {
            int managerID = Integer.parseInt((String) ctx.req.getSession().getAttribute("id"));

            if (managerID != 2) {
                ctx.status(401);
                ctx.result("Must be manager to view employee ticket");
            }
            else{
                User u = om.readValue(ctx.body(), User.class);
                ctx.result(om.writeValueAsString(rs.managerByEmployee(u.getUser_id())));
            }
        }

    };
}

