package com.example.challengermazzatech;

public class User {
    String image;
    String name;
    String username;
    String email;
    String password;
    String address;
    String age;
    String sex;
    String type;
    String cpf;

    boolean login;

    public User (String name, String email, String password, String username, String address, String age, String sex, String type, String cpf, boolean login, String image) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.address = address;
        this.age = age;
        this.sex = sex;
        this.type = type;
        this.cpf = cpf;
        this.login = login;
        this.password = password;
        this.image = image;
    }

    public boolean isLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getType() {
        return type;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPassword() { return password; }

    public String image() { return image; }
};
