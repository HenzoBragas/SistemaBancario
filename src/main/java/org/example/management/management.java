package org.example.management;

import org.example.info.Account;
import org.example.info.Client;

import java.util.ArrayList;

public class Management {
    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Account> accounts = new ArrayList<>();


    //Cadastra Cliente se CPF ñ existir
    public boolean registerCustomer(Client client, int numberAccount, double initialDeposit) {
        if (searchClientCPF(client.getCpf()) != null) {
            return false;
        }
        clients.add(client);

        Account account = new Account(client, numberAccount, initialDeposit);
        accounts.add(account);
        return true;
    }

    public Client searchClientCPF(String cpf) {
        for (Client c : clients) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    public Account searchAccount(int numberValue) {
        for (Account account : accounts) {
            if (account.getNumberAccount() == numberValue) {
                return account;
            }
        }
        return null;
    }

    public void listAccounts() {
        for (Account account : accounts) {
            System.out.println("Conta: " + account.getNumberAccount() +
                    ", Cliente: " + account.getClient().getName() +
                    ", Saldo: R$" + account.getBalance());
        }
    }

    public void unicListAccount(Account account) {
        if (account != null) {
            System.out.println("Conta: " + account.getNumberAccount() +
                    ", Cliente: " + account.getClient().getName() +
                    ", Saldo: R$" + account.getBalance());
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

}

