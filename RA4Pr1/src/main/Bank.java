/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author henar
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Bank {
    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<>();
        
        crearCuentas(accounts, 2);
        
        int opcion;
        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    consultarDatos(accounts);
                    break;
                case 2:
                    consultarSaldo(accounts);
                    break;
                case 3:
                    ingresarDinero(accounts);
                    break;
                case 4:
                    retirarDinero(accounts);
                    break;
                case 5:
                    realizarTransferencia(accounts);
                    break;
            }
        } while (opcion != 6);
        
        System.out.println("El programa se ha cerrado");
    }
    
    public static void crearCuentas(ArrayList<Account> accounts, int cantidad) {
        if (cantidad <= 0) {
            System.exit(1);
        }
        
        Scanner sc = new Scanner(System.in);
        
        for (int i = 1; i <= cantidad; i++) {
            System.out.print("Ingrese el nombre del titular de la cuenta " + i + ": ");
            String name = sc.nextLine();
            
            System.out.print("Ingrese el apellido del titular de la cuenta " + i + ": ");
            String surname = sc.nextLine();
                        
            System.out.print("Ingrese la edad del titular de la cuenta " + i + ": ");
            int age = sc.nextInt();
            sc.nextLine(); 
            
            if (age < 18) {
                System.out.println("");
                System.out.println("El usuario tiene menos de 18 de años. Intentalo de nuevo");
                System.out.println("");
                
                i--;
                continue;
            }
            
            System.out.print("Ingrese el saldo inicial de la cuenta " + i + ": ");
            double balance = sc.nextDouble();
            sc.nextLine();
            
            accounts.add(new Account(name, surname, age, i, balance));
            
            System.out.println("");
        }
    }
    
    public static int menu() {
        System.out.println("");
        System.out.println("Menú principal");
        System.out.println("1.  Consultar datos");
        System.out.println("2.  Consultar saldo");
        System.out.println("3.  Ingresar dinero");
        System.out.println("4.  Sacar dinero");
        System.out.println("5.  Realizar transferencia");
        System.out.println("6.  Salir");
        System.out.print("Ingrese una opción: ");
        
        Scanner sc = new Scanner(System.in);
        
        int opcion;
        do {
            opcion = sc.nextInt();
        } while (opcion < 1 || opcion > 6);
        
        return opcion;
    }
    
    public static String pedirNombre() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese el nombre del titular: ");
        return sc.nextLine();
    }
    
    public static Account copiarCuenta(ArrayList<Account> accounts, String nombre) {
        for (int i = 0; i < accounts.size(); i++) {
            if (nombre.equalsIgnoreCase(accounts.get(i).getName())) {
                return accounts.get(i);
            }
        }
        return null;
    }
    
    public static void consultarDatos(ArrayList<Account> accounts) {
        String nombre = pedirNombre();
        
        Account account = copiarCuenta(accounts, nombre);
        
        System.out.println("");
        if (account == null) {
            System.out.println("No hay una cuenta con el nombre " + nombre);
            return;
        }
              
        System.out.println(account.getHolder());
    }
    
    public static void consultarSaldo(ArrayList<Account> accounts) {
        String nombre = pedirNombre();
          
        Account account = copiarCuenta(accounts, nombre);
        
        System.out.println("");
        if (account == null) {
            System.out.println("No hay una cuenta con el nombre " + nombre);
            return;
        }
        
        System.out.println("El saldo de la cuenta es: " + account.getBalance());
    }
    
    public static void ingresarDinero(ArrayList<Account> accounts) {
        String nombre = pedirNombre();
        
        Account account = copiarCuenta(accounts, nombre);
        
        if (account == null) {
            System.out.println("");
            System.out.println("No hay una cuenta con el nombre " + nombre);
            return;
        }
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese la cantidad a ingresar: ");
        account.ingresar(sc.nextDouble()); 
        
        System.out.println("");
        System.out.println("El dinero ha sido ingresado a la cuenta");
    }
    
    public static void retirarDinero(ArrayList<Account> accounts) {
        String nombre = pedirNombre();
        
        Scanner sc = new Scanner(System.in);
        
        Account account = copiarCuenta(accounts, nombre);
          
        if (account == null) {
            System.out.println("");
            System.out.println("No hay una cuenta con el nombre " + nombre);
            return;
        }
        
        System.out.print("Ingrese la cantidad a retirar: ");
        
        double dinero = sc.nextDouble();
        
        if (dinero > account.getBalance()) {
            System.out.println("");
            System.out.println("La cuenta no tiene suficiente saldo");
            return;
        }
        
        account.retirar(dinero);
        
        System.out.println("");
        System.out.println("El dinero ha sido ingresado a la cuenta");
    }
    
    public static void realizarTransferencia(ArrayList<Account> accounts) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese el nombre del titular origen: ");
        String origen = sc.nextLine();
        
        System.out.print("Ingrese el nombre del titular destino: ");
        String destino = sc.nextLine();
        
        Account accountOrigen = copiarCuenta(accounts, origen);
        
        if (accountOrigen == null) {
            System.out.println("");
            System.out.println("No hay una cuenta origen con el nombre " + origen);
            return;
        }
        
        Account accountDestino = copiarCuenta(accounts, destino);
        
        if (accountDestino == null) {
            System.out.println("");
            System.out.println("No hay una cuenta destino con el nombre " + destino);
            return;
        }
        
        System.out.print("Ingrese la cantidad a transferir: ");
        double dinero = sc.nextDouble();
        
        if (dinero > accountOrigen.getBalance()) {
            System.out.println("");
            System.out.println("La cuenta de origen no tiene suficiente saldo");
            return;
        }
        
        accountOrigen.retirar(dinero);
        accountDestino.ingresar(dinero);
        
        System.out.println("");
        System.out.println("La transferencia se realizó con éxito");
    }
}


