
package discountstrategy;

/**
 * Interface for a generic receipt.
 * 
 * @author Liz Ife Van Deslunt
 */
public interface ReceiptStrategy {
    
    /**
     * Gets the customer's receipt as a formatted String.
     * 
     * @return The customer's receipt as a formatted String.
     */
    public String getReceipt();
    
    /**
     * Sets the customer making the purchase.
     * @param customerID - The customerID of the customer making the purchase.
     */
    public void setCustomer(int customerID) throws IllegalArgumentException;
    /**
     * Adds a product to the receipt.
     * @param prodID - productID of the item.
     * @param qty - quantity purchased.
     */
    public void addProductToReceipt(int prodID, int qty) throws IllegalArgumentException;
    
    /**
     * Sets the database used to store products and customers.
     * @param db 
     */
    public void setDatabase(DatabaseStrategy db) throws  NullPointerException;
    
    
    
}
