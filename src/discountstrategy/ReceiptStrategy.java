/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 * Interface for a generic receipt.
 * 
 * @author Liz Ife Van Deslunt
 */
public interface ReceiptStrategy {
    
    public void printReceipt();
    public void setCustomer(int customerID);
    public void addProductToReceipt(int prodID, int qty);
    
    public void setDatabase(DatabaseStrategy db);
    public DatabaseStrategy getDatabase();
    
    
}
