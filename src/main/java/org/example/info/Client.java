package org.example.info;

public class Client {
    private String name;
    private final String cpf;
    private char gender;

    public Client(String name, String cpf, char gender) {
        this.name = name;
        this.cpf = cpf;
        this.gender = gender;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
