package models;

public class Users extends BaseEntity{

    private String login;
    private String password;
    private Shop shop;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @Override
    public String toString() {
        return super.toString() +
                "| login:" + login +
                "| password: " + password +
                "| shop: " + shop;
    }
}
