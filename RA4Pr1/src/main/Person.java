/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author henar
 */
public class Person {
    private String name;
    private String surname;
    private int age;
    
    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    
    public String getName() {
        return this.name;
    }
            
    @Override
    public String toString() {
        return "El nombre del titular es " + name + ", el apellido es " + surname + ", y la edad es " + age;
    }
}
