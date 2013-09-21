/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author Liz Ife Van Deslunt
 */
public class JavaDatabase implements Database{
    private final int INIT_PRODUCT_ARRAY_SIZE = 1;
     private final int INIT_CUSTOMER_ARRAY_SIZE = 1;
     
    private Product[] products;
    private Customer[] customers;
    
    
    /**
     * Constructor that creates the customer and product arrays.
     */
    public JavaDatabase(){
        products = new Product[INIT_PRODUCT_ARRAY_SIZE];
        customers = new Customer[INIT_CUSTOMER_ARRAY_SIZE];
    }
    
    /**
     * Constructor that lets you pass in arrays.
     * @param p 
     */
    public JavaDatabase(Product[] p, Customer[] c){
        
    }
         
    // methods we need:
    // * find
    // * get array
    // * get item from array
    // * set array
    // * resize array
    // * add to array
    // * remove from array
    
    public final Customer findCustomer(int customerID){
        return find(customers, customerID);
    }
    
    private void add(Object[] array, Object o){
        if(array[array.length - 1] == null){
            expandArray(array);
        }
        array[array.length - 1] = o;
    }
    
    private final Object get(int index){
        
        
    }
    
    private final Object find(Object[] array, int uniqueID){
        
    }
    
    /**
     * Manual array resize. Adds one extra slot to the end of the array.
     * @param array The array to resize
     */
    private Object[] expandArray(Object[] array){
        Object[] tmp = new Object[array.length + 1];
        
        for(int i = 0; i < array.length; i++){
            tmp[i] = array[i];
        }
        
        return tmp;
    }
}
