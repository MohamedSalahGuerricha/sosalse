package Model;

public class Invoice_product {

    private int id;
    private int invoices_id;
    private String product;
    private double price;
    private double amount;
    private int quntity;
    private String comment;

    public Invoice_product() {

    }

    public Invoice_product(int invoices_id, String product, double price, double amount, int quntity, String comment) {
        this.invoices_id = invoices_id;
        this.product = product;
        this.price = price;
        this.amount = amount;
        this.quntity = quntity;
        this.comment = comment;
    }

    public Invoice_product(int id, int invoices_id, String product, double price, double amount, int quntity, String comment) {
        this.id = id;
        this.invoices_id = invoices_id;
        this.product = product;
        this.price = price;
        this.amount = amount;
        this.quntity = quntity;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvoices_id() {
        return invoices_id;
    }

    public void setInvoices_id(int invoices_id) {
        this.invoices_id = invoices_id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getQuntity() {
        return quntity;
    }

    public void setQuntity(int quntity) {
        this.quntity = quntity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
