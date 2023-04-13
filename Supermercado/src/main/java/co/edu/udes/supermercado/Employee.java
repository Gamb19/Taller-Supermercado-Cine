/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udes.supermercado;

/**
 *
 * @author molin
 */
public class Employee extends Person{
    private double salary;
    private String section_area;

    public Employee(double salary, String section_area, String name, int id) {
        super(name, id);
        this.salary = salary;
        this.section_area = section_area;
    }

    public Employee(double salary, String section_area) {
        this.salary = salary;
        this.section_area = section_area;
    }

    public Employee() {
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSection_area() {
        return section_area;
    }

    public void setSection_area(String section_area) {
        this.section_area = section_area;
    }

    @Override
    public String toString() {
        return "Employee{" + "salary=" + salary + ", section_area=" + section_area + '}';
    }

  
    
    
    
}
