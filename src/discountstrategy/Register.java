/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 * Cash register that handles input and output between the startup class and 
 * the receipt.
 * @author Liz Ife Van Deslunt
 */
public class Register {
    // error messages
    private final static String RECEIPT_ERR = "Please enter a valid receipt type.";
    
    // global variables
    private Receipt receipt;
    
    public Register(int customerID){
        initializeReceipt(customerID);
    }

    //public methods
    
    public final void addProductToReceipt(int prodID, int quantity){
        receipt.addProductToReceipt(prodID, quantity);
    }
    
    public final void changeReceiptType(Receipt receipt){
        if(receipt == null){
            throw new NullPointerException(RECEIPT_ERR);
        }
        this.receipt = receipt;
    }
    
    public final void printReceipt(){
        receipt.printReceipt();
    }
    
    //private methods
    
    private void initializeReceipt(int customerID){
        //validation is delegated to receipt.
       receipt = new RegisterReceipt(customerID);
    }
    
}
