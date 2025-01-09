/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author henar
 */
public class Account {
    private Person holder;
    private final int number;
    private double balance;
    
    
    public Account(String name, String surname, int age, int number, double initialBalance) {
        this.holder = new Person(name, surname, age);
        this.number = number;
        this.balance = initialBalance; 
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public double getBalance() {
        return this.balance;
    } 
    
    public Person getHolder() {
        return this.holder;
    }
    
    public String getName() {
        return this.holder.getName();
    }
    
    public void ingresar(double money) {
        this.balance += money;
    }
    
    public void retirar(double money) {
        this.balance -= money;
    }
}
