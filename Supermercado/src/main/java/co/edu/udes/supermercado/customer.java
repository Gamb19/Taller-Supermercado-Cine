/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udes.supermercado;

/**
 *
 * @author molin
 */
public class customer extends Person {
    private String cell_number;
    private String mail;
    
    public customer(String cell_number, String mail,String name, int id) {
        super(name, id);
        this.cell_number = cell_number;
        this.mail = mail;
        
    }

    public customer(String cell_number, String mail, String cellphone) {
        this.cell_number = cell_number;
        this.mail = mail;
        
    }

    
    public String getCell_number() {
        return cell_number;
    }

    public void setCell_number(String cell_number) {
        this.cell_number = cell_number;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

   
  
    
    
    
    
}
