package com.revature.dao;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.User;

import java.sql.Date;
import java.util.List;

public interface Ireimbursement {

    /*          Employee
    Submit a reimbursement request
    View pending reimbursement requests
    View resolved reimbursement requests*/

    public void employeeCreateReimbursement(Reimbursement r);

    // Change it to include user at later date for pending and resolved
    public List<Reimbursement> employeeViewAllPending(int i);

    public List<Reimbursement> employeeViewAllResolved(int id);


    //---------------------------------------------------------------------------

    /*          Manager
    Approve pending reimbursement requests
    Deny pending reimbursement requests
    View all pending requests of all employees
    View all resolved requests of all employees
    View reimbursement requests of a specific employee*/


    public Reimbursement managerApproveRequest(int manager, int user);

    public Reimbursement managerDenyRequest(int manager, int user);

    public List<Reimbursement> managerViewAllPending();

    public List<Reimbursement> managerViewAllResolved();

    public List<Reimbursement> managerViewAllByEmployee(int id);
}
