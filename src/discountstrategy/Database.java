/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 * Interface for a basic database that stores products and customers.
 * 
 * @author Liz Ife Van Deslunt
 */
public interface Database {
    
    public void addCustomer(Customer c);
    public Customer findCustomer(int customerID);
    
    public void addProduct(Product p);
    public Product findProduct(int productID);
    
    
    
}
