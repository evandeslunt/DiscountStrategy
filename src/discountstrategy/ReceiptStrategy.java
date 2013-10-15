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
    
    /**
     * Prints the customer's receipt.
     */
    public void printReceipt();
    
    /**
     * Sets the customer making the purchase.
     * @param customerID - The customerID of the customer making the purchase.
     */
    public void setCustomer(int customerID);
    /**
     * Adds a product to the receipt.
     * @param prodID - productID of the item.
     * @param qty - quantity purchased.
     */
    public void addProductToReceipt(int prodID, int qty);
    
    /**
     * Sets the database used to store products and customers.
     * @param db 
     */
    public void setDatabase(DatabaseStrategy db);
    
    
    
}
