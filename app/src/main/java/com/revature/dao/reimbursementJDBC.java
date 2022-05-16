package com.revature.dao;

import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionSingleton;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class reimbursementJDBC implements Ireimbursement{

    private ConnectionSingleton cs = ConnectionSingleton.getConnectionSingleton();

    @Override
    public void employeeCreateReimbursment(Reimbursement r) {

        Connection c = cs.getConnection();

        String sql = "insert into reimbursement (amount, submitted_date, description, reimbursement_author) values" +
                "('" + r.getAmount() + "','" +
                r.getSubmitted_date() + "','" +
                r.getDescription() + "','" +
                r.getReimbursement_author() + "')";


        try{
            Statement s = c.createStatement();

            s.execute(sql);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Reimbursement> employeeViewPending(int id) {

        List<Reimbursement>  employeeViewPending = new ArrayList<Reimbursement>();
        Connection c = cs.getConnection();

        try{
            String sql = "SELECT * FROM REIMBURSEMENTS ORDER BY reimbursement_id";
            // Statement... Potential for SQL injection
            PreparedStatement statement = null;
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
                Reimbursement r = new Reimbursement();
                r.setReimbursement_id(rs.getInt(1));
                r.setAmount(rs.getInt(2));
                r.setSubmitted_date(LocalDate.parse(rs.getString(3)));
                r.setResolved_date(LocalDate.parse(rs.getString(4)));
                r.setDescription(rs.getString(5));
                r.setReimbursement_author(rs.getInt(6));
                r.setReimbursement_resolver(rs.getInt(7));
                r.setReimbursement_status(rs.getInt(8));
                r.setReimbursement_type(rs.getInt(9));

                employeeViewPending.add(r);
            }
            Statement s = c.createStatement();

            s.execute(sql);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return  employeeViewPending;
    }

    @Override
    public List<Reimbursement> employeeViewResolved(int id) {
        List<Reimbursement> employeeViewResolved = new ArrayList<Reimbursement>();
        Connection c = cs.getConnection();

        try{
            String sql = "SELECT * FROM REIMBURSEMENTS ORDER BY reimbursement_id";
            // Statement... Potential for SQL injection
            PreparedStatement statement = null;
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
                Reimbursement r = new Reimbursement();
                r.setReimbursement_id(rs.getInt(1));
                r.setAmount(rs.getInt(2));
                r.setSubmitted_date(LocalDate.parse(rs.getString(3)));
                r.setResolved_date(LocalDate.parse(rs.getString(4)));
                r.setDescription(rs.getString(5));
                r.setReimbursement_author(rs.getInt(6));
                r.setReimbursement_resolver(rs.getInt(7));
                r.setReimbursement_status(rs.getInt(8));
                r.setReimbursement_type(rs.getInt(9));

                employeeViewResolved.add(r);
            }
            Statement s = c.createStatement();

            s.execute(sql);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return employeeViewResolved;
    }



    @Override
    public void employeeDeleteReimbursement(Reimbursement r) {


    }

    @Override
    public List<Reimbursement> viewByManager(int id) {
        return null;
    }

    @Override
    public List<Reimbursement> viewAllByManager(int id) {
        return null;
    }

    @Override
    public List<Reimbursement> viewAllPendingByManager(int id) {
        return null;
    }

    @Override
    public List<Reimbursement> viewAllResolvedByManager(int id) {
        return null;
    }

    @Override
    public void managerDeleteReimbursement(Reimbursement r) {

    }
}

