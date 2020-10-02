package Model;

public class Employee {

    public int id;
    public String username;
    public String password;
    public String phone;
    public int type;

    public Employee() {

    }

    public Employee(String username, String password, String phone, int type) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.type = type;
    }

    public Employee(int id, String username, String password, String phone, int type) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", type=" + type +
                '}';
    }
}
