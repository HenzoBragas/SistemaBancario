package org.example;
import org.example.management.Management;
import org.example.menu.Menu;

public class Main {
    public static void main(String[] args) {
        Management management = new Management();
        Menu menu = new Menu(management);
        menu.menu();

        }
    }
