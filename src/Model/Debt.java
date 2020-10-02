package Model;

import java.sql.Date;

public class Debt{
    private int id;
    private String client;
    private double amount;
    private String employee;
    private Date date;
    private String comment;

    public Debt() {

    }

    public Debt(double amount, String client, String employee,Date date, String comment) {
        this.amount = amount;
        this.client = client;
        this.employee = employee;
        this.date=date;
        this.comment = comment;
    }

    public Debt(int id, double amount, String client, String employee,Date date, String comment) {
        this.id = id;
        this.amount = amount;
        this.client = client;
        this.employee = employee;
        this.date=date;
        this.comment = comment;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}