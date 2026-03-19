
package com.mycompany.gerenciador.ordens.model;

public class User {
    private int id;
    private String cpf;
    private String name_user;
    private String email;
    private String password_user;
    private String profile_user;

    public User() {
    }

    public User(String cpf, String name_user, String email, String password_user, String profile_use) {
        this.cpf = cpf;
        this.name_user = name_user;
        this.email = email;
        this.password_user = password_user;
        this.profile_user = profile_use;
    }
    
    public User(int id, String cpf, String name_user, String email, String password_user, String profile_use) {
        this.id = id;
        this.cpf = cpf;
        this.name_user = name_user;
        this.email = email;
        this.password_user = password_user;
        this.profile_user = profile_use;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword_user() {
        return password_user;
    }

    public void setPassword_user(String password_user) {
        this.password_user = password_user;
    }

    public String getProfile_user() {
        return profile_user;
    }

    public void setProfile_user(String profile_use) {
        this.profile_user = profile_use;
    }
}
