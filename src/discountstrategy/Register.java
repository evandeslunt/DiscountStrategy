/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author Liz Ife Van Deslunt
 */
public class Register {
    
    private Receipt receipt;
    
    public Register(int customerID){
        initializeReceipt(customerID);
    }

    //public methods
    
    public final void addProductToReceipt(int prodID, int quantity){
        receipt.addProductToReceipt(prodID, quantity);
    }
    
    public final void printReceipt(){
        receipt.printReceipt();
    }
    
    //private methods
    
    private void initializeReceipt(int customerID){
        //validation has already occurred when we set customerID
        receipt = new RegisterReceipt(customerID);
    }
    
}
