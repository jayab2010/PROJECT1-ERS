package com.revature.models;

import java.time.LocalDate;

public class Reimbursement {
    private int reimbursement_id;
    private int amount;
    private LocalDate submitted_date;
    private  LocalDate resolved_date;
    private String description;
    private int reimbursement_author;
    private int reimbursement_resolver;
    private int reimbursement_status;
    private int reimbursement_type;

    public Reimbursement() {
    }

    // employee creating a ticket
    public Reimbursement(int amount, LocalDate submitted_date, String description, int reimbursement_author) {
        //this.reimbursement_id = reimbursement_id;
        this.amount = amount;
        this.submitted_date = submitted_date;
        //this.resolved_date = resolved_date;
        this.description = description;
        this.reimbursement_author = reimbursement_author;
        //this.reimbursement_resolver = reimbursement_resolver;
        //this.reimbursement_status = reimbursement_status;
        //this.reimbursement_type = reimbursement_type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReimbursement_id() {
        return reimbursement_id;
    }

    public void setReimbursement_id(int reimbursement_id) {
        this.reimbursement_id = reimbursement_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public  LocalDate getSubmitted_date() {
        return submitted_date;
    }

    public void setSubmitted_date( LocalDate submitted_date) {
        this.submitted_date = submitted_date;
    }

    public  LocalDate getResolved_date() {
        return resolved_date;
    }

    public void setResolved_date( LocalDate resolved_date) {
        this.resolved_date = resolved_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDecription(String decription) {
        this.description = decription;
    }

    public int getReimbursement_author() {
        return reimbursement_author;
    }

    public void setReimbursement_author(int reimbursement_author) {
        this.reimbursement_author = reimbursement_author;
    }

    public int getReimbursement_resolver() {
        return reimbursement_resolver;
    }

    public void setReimbursement_resolver(int reimbursement_resolver) {
        this.reimbursement_resolver = reimbursement_resolver;
    }

    public int getReimbursement_status() {
        return reimbursement_status;
    }

    public void setReimbursement_status(int reimbursement_status) {
        this.reimbursement_status = reimbursement_status;
    }

    public int getReimbursement_type() {
        return reimbursement_type;
    }

    public void setReimbursement_type(int reimbursement_type) {
        this.reimbursement_type = reimbursement_type;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbursement_id=" + reimbursement_id +
                ", amount=" + amount +
                ", submitted_date=" + submitted_date +
                ", resolved_date=" + resolved_date +
                ", decription='" + description + '\'' +
                ", reimbursement_author=" + reimbursement_author +
                ", reimbursement_resolver=" + reimbursement_resolver +
                ", reimbursement_status=" + reimbursement_status +
                ", reimbursement_type=" + reimbursement_type +
                '}';
    }
}

