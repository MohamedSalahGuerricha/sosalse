package Model;

public class Stock {

    public int id;
    public String name;
    public String adress;
    public String admin;

    public Stock() {

    }

    public Stock(String name, String adress, String admin) {
        this.name = name;
        this.adress = adress;
        this.admin = admin;
    }

    public Stock(int id, String name, String adress, String admin) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.admin = admin;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
}
