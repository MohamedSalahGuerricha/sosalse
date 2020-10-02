package Model;

import java.sql.Date;

public class Invoice {
// UPDATE `employee` SET `username` = 'salah', `password` = '1234', `phone` = '0699821139', `type` = '1' WHERE `employee`.`id` = 1;
    //INSERT INTO `invoice` (`id`, `client`, `Total`, `debt`, `employee`, `date`, `comment`) VALUES ('1', 'علي', '1234.44', '22', 'salah', '2020-07-09 17:12:55', 'no comment');
    private int id;
    private String client;
    private Double Total;
    private Double debt;
    private String employee;
    private Date date;
    private String comment;

    public Invoice() {

    }

    public Invoice(String client, Double total, Double debt, String employee,Date date, String comment) {
        this.client = client;
        Total = total;
        this.debt = debt;
        this.employee = employee;
        this.date = date;
        this.comment = comment;
    }

    public Invoice(int id, String client, Double total, Double debt, String employee,Date date, String comment) {
        this.id = id;
        this.client = client;
        this.Total = total;
        this.debt = debt;
        this.employee = employee;
        this.date = date;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double total) {
        Total = total;
    }

    public Double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
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
