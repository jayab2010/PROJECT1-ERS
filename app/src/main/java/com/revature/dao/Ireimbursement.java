package com.revature.dao;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;

import java.util.List;

public interface Ireimbursement {

    public void employeeCreateReimbursment(Reimbursement r);

    public List<Reimbursement> employeeViewPending(int id);

    public List<Reimbursement> employeeViewResolved(int id);

    public void employeeDeleteReimbursement( Reimbursement r);




    public List<Reimbursement> viewByManager(int id);

    public List<Reimbursement> viewAllByManager(int id);

    public List<Reimbursement> viewAllPendingByManager(int id);

    public List<Reimbursement> viewAllResolvedByManager(int id);

    public void managerDeleteReimbursement( Reimbursement r);

}