/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;


/**
 * @author Liz Ife Van Deslunt
 */
public class Startup {
    
    public static void main(String[] args){
       
       
       Database db = new JavaDatabase();
       Register reg = new Register(100);
       
       reg.addProductToReceipt(1000, 3);
       reg.addProductToReceipt(1001, 1);
       
       reg.printReceipt();
        
        
    }
    
}
