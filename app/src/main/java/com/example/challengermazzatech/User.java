package com.example.challengermazzatech;

public class User {
    String name;
    String username;
    String email;
    String address;
    String age;
    String sex;
    String type;
    String cpf;

    boolean login;

    public User (String name, String email, String username, String address, String age, String sex, String type, String cpf, boolean login) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.address = address;
        this.age = age;
        this.sex = sex;
        this.type = type;
        this.cpf = cpf;
        this.login = login;
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
};
