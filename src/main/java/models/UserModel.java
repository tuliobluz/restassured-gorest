package models;

public class UserModel {

    private String name;
    private String gender;
    private String email;
    private String status;

    public String getName() {
        return name;
    }

    public UserModel setName(String name) {

        this.name = name;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public UserModel setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public UserModel setStatus(String status) {
        this.status = status;
        return this;
    }

    public UserModel(String name,
                     String gender,
                     String email,
                     String status) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.status = status;
    }
}
