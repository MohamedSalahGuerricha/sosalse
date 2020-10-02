package Model;

public class Stock_product {

    public int id;
    public String product;
    public int quntity;
    public String stock;
    public String comment;

    public Stock_product() {

    }

    public Stock_product(String product, int quntity, String stock, String comment) {
        this.product = product;
        this.quntity = quntity;
        this.stock = stock;
        this.comment = comment;
    }

    public Stock_product(int id, String product, int quntity, String stock, String comment) {
        this.id = id;
        this.product = product;
        this.quntity = quntity;
        this.stock = stock;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuntity() {
        return quntity;
    }

    public void setQuntity(int quntity) {
        this.quntity = quntity;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
