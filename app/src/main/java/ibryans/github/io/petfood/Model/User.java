package ibryans.github.io.petfood.Model;

public class User {

    //  User credentials
    private String name;
    private String petName;
    private String petEspecie;
    private String petSex;

    public User(String userName, String petName, String petEspecie, String petSex) {
        this.name = userName;
        this.petName = petName;
        this.petEspecie = petEspecie;
        this.petSex = petSex;
    }

    public String getName() {
        return name;
    }

    public void setName(String userName) {
        this.name = userName;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetEspecie() {
        return petEspecie;
    }

    public void setPetEspecie(String petEspecie) {
        this.petEspecie = petEspecie;
    }

    public String getPetSex() {
        return petSex;
    }

    public void setPetSex(String petSex) {
        this.petSex = petSex;
    }
}