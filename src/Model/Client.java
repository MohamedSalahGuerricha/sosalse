package Model;

public class Client {

    public int id;
    public String name;
    public String phone;
    public String adress;
    public int type;
    public String NB;
    public String CCP;

    public Client() {

    }

    public Client(String name, String phone, String adress, int type, String NB, String CCP) {
        this.name = name;
        this.phone = phone;
        this.adress = adress;
        this.type = type;
        this.NB = NB;
        this.CCP = CCP;
    }

    public Client(int id, String name, String phone, String adress, int type, String NB, String CCP) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.adress = adress;
        this.type = type;
        this.NB = NB;
        this.CCP = CCP;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getNB() {
        return NB;
    }

    public void setNB(String NB) {
        this.NB = NB;
    }

    public String getCCP() {
        return CCP;
    }

    public void setCCP(String CCP) {
        this.CCP = CCP;
    }
}
