package Model;

import java.sql.Date;

public class Product {

    private int id;
    private String name;
    private int codpar;
    private double selling_price;
    private double Purchasing_price;
    private java.sql.Date Expiration_date;
    private String catgory;
    private int minmum_stock;
    private String comment;


    public Product() {

    }

    public Product(String name, int codpar, double selling_price, double purchasing_price, Date expiration_date, String catgory,int minmum_stock, String comment) {
        this.name = name;
        this.codpar = codpar;
        this.selling_price = selling_price;
        Purchasing_price = purchasing_price;
        Expiration_date = expiration_date;
        this.catgory = catgory;
        this.comment = comment;
    }

    public Product(int id, String name, int codpar, double selling_price, double purchasing_price, Date expiration_date, String catgory,int minmum_stock, String comment) {
        this.id = id;
        this.name = name;
        this.codpar = codpar;
        this.selling_price = selling_price;
        Purchasing_price = purchasing_price;
        Expiration_date = expiration_date;
        this.catgory = catgory;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCodpar() {
        return codpar;
    }

    public void setCodpar(int codpar) {
        this.codpar = codpar;
    }

    public double getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(double selling_price) {
        this.selling_price = selling_price;
    }

    public double getPurchasing_price() {
        return Purchasing_price;
    }

    public void setPurchasing_price(double purchasing_price) {
        Purchasing_price = purchasing_price;
    }

    public Date getExpiration_date() {
        return Expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        Expiration_date = expiration_date;
    }

    public String getCatgory() {
        return catgory;
    }

    public void setCatgory(String catgory) {
        this.catgory = catgory;
    }

    public String getComment() {
        return comment;
    }

    public int getMinmum_stock() {
        return minmum_stock;
    }

    public void setMinmum_stock(int minmum_stock) {
        this.minmum_stock = minmum_stock;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
