package org.example.banco;

public class Account {
    private int numberAccount;
    private double balance;
    private Client client;

    public Account(double balance, Client client) {
        this.balance = balance;
        this.client = client;
    }

    public void deposit(double value){
        if(value > 0)
            balance += value;
    }
    public void withdraw(double value){
        balance -= value;
    }

    public double getBalance(){
        return balance;
    }


    public int getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(int numberAccount) {
        this.numberAccount = numberAccount;
    }

    public Client getClient() {
        return client;
    }

}
