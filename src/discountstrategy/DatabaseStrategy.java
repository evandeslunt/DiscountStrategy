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
public interface DatabaseStrategy {
    
    public void addCustomer(Customer c) throws NullPointerException;
    public Customer findCustomer(int customerID) throws IllegalArgumentException;
    
    public void addProduct(Product p) throws NullPointerException;
    public Product findProduct(int productID) throws IllegalArgumentException;
    
    
    
}
