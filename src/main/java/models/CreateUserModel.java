package models;

public class CreateUserModel {

    private String name;
    private String gender;
    private String email;
    private String status;

    public String getName() {
        return name;
    }

    public CreateUserModel setName(String name) {

        this.name = name;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public CreateUserModel setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreateUserModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public CreateUserModel setStatus(String status) {
        this.status = status;
        return this;
    }

    public CreateUserModel(String name,
                           String gender,
                           String email,
                           String status) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.status = status;
    }
}
