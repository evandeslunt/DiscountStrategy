/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author Liz Ife Van Deslunt
 */
public interface Receipt {
    
    public void printReceipt();
    public void setLineItems(LineItem[] lineItems);
    public void setCustomer(Customer customer);
    
    
}
