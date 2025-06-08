package org.example;

import org.example.info.Account;
import org.example.info.Client;
import org.example.management.BankManager;

import java.util.Scanner;

public class Menu {
    private BankManager bankManager;
    private Scanner sc;

    public Menu(BankManager bankManager){
        this.bankManager = bankManager;
        this.sc = new Scanner(System.in);
    }

    public void menu(){
        int option;
        do {
            System.out.println("\n--- Menu do Banco ---");
            System.out.println("1. Cadastrar cliente com conta");
            System.out.println("2. Depositar");
            System.out.println("3. Saquar");
            System.out.println("4. Extrato");
            System.out.println("5. Listar contas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> registerUser();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> extract();
                case 5 -> bankManager.listAccounts();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (option != 0);
    }

    public void registerUser() {
        System.out.print("Nome: ");
        String name = sc.nextLine();

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        System.out.print("Gênero (M/F) :  ");
        char gender = sc.next().charAt(0);
        sc.nextLine();

        System.out.println("Digite o numero da conta");
        int numberAccount = sc.nextInt();

        System.out.println("Deseja fazer um deposito inicial (y/n): ");
        sc.nextLine();
        char response = sc.next().charAt(0);

        double initialDeposit = 0;
        if (response == 'y' || response == 'Y') {
            System.out.println("Digite o deposito inicial: ");
            initialDeposit = sc.nextDouble();
            sc.nextLine();
        }

        Client client = new Client(name, cpf, gender);
        boolean register = bankManager.registerCustomer(client, numberAccount, initialDeposit);

        if (register) {
            System.out.println("Cliente e conta cadastrados com sucesso!");
        } else {
            System.out.println("CPF já cadastrado!");
        }
    }

    public void deposit(){
        System.out.println("Digite numero da sua conta para deposito: ");
        int accountNumber = sc.nextInt();
        Account account = bankManager.searchAccount(accountNumber);

        if (account != null) {
            bankManager.unicListAccount(account);
            System.out.print("Digite o valor do depósito: ");
            double value = sc.nextDouble();
            account.deposit(value);
            System.out.println("Depósito realizado com sucesso! Novo saldo: R$" + account.getBalance());
        } else {
            System.out.println("Conta não encontrada.");
        }

    }

    public void withdraw(){

        System.out.println("Digite numero da sua conta para saque: ");
        int accountNumber = sc.nextInt();
        Account account = bankManager.searchAccount(accountNumber);

        if(account != null) {
            bankManager.unicListAccount(account);
            System.out.println("Digite o valor do saque");
            double value = sc.nextDouble();
            account.withdraw(value);
            System.out.println("Saque realizado com sucesso! Novo saldo: R$" + account.getBalance());
        }else {
            System.out.println("Conta não encontrada.");
        }

    }

    public void extract(){
        System.out.println("Digite o numero da sua conta para extrato: ");
        int accountNumber = sc.nextInt();
        Account account = bankManager.searchAccount(accountNumber);

        if (account != null) {
            bankManager.unicListAccount(account);
        }else {
            System.out.println("Conta não encontrada.");
        }


    }

}
