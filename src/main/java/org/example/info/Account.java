package org.example.info;

public class Account {
    private int numberAccount;
    private double balance;
    private Client client;

    public Account(Client client, int numberAccount, double initialDeposit) {
        this.client = client;
        this.numberAccount = numberAccount;
        deposit(initialDeposit);
    }

    public Account(Client client, int numberAccount) {
        this.client = client;
        this.numberAccount = numberAccount;
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
