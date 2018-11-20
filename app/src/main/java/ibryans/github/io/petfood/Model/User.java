package ibryans.github.io.petfood.Model;

public class User {

    //  Login credentials
    private String login;
    private String password;

    //  User credentials
    private String userName;


    public User(String log, String pass, String un) {
        this.login    = log;
        this.password = pass;
        this.userName = un;
    }


    /* *** Getters and setters  *** */

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}