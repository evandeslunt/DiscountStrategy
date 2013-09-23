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
    private final String FIND_ERR = "There was an error finding the requested object";
    
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
       setProductList(p);
       setCustomerList(c);
    }
         
    
    //customer methods
        /**
         * Returns the customer with the given customerID, or null if not found.
         * @param customerID
         * @return 
         */
        @Override
        public final Customer findCustomer(int customerID) {
           if(customerID < 0){
               throw new IllegalArgumentException();
           }
           for(Customer customer : customers){
               if(customer.getCustomrID() == customerID){
                   return customer;
               }
           }
           return null;
        }
        
        @Override
        public final void addCustomer(Customer c){
            if(c == null){
                throw new NullPointerException();
            } else if (!(c instanceof Customer)){
                throw new IllegalArgumentException();
            } 

            add(customers, c);
        }
        
        /**
         * Sets the customers array to the given array.
         * @param customers A Customer[] array
         */
         public final void setCustomerList(Customer[] customers){
             if(customers == null){
                 throw new NullPointerException();
             }
             this.customers = customers;
         }
         
         
         //product methods
        
         /**
          * Returns the product with the given productID, or null if not found.
          * @param productID
          * @return 
          */
        @Override
        public final Product findProduct(int productID){
            if(productID < 0){
                throw new IllegalArgumentException();
            } 
            for(Product prod : products){
                if(prod.getItemNumber() == productID){
                    return prod;
                }
            }
            
            return null;
            
      }
        
      @Override
      public final void addProduct(Product p){
          if(p == null){
              throw new NullPointerException();
          } else if (!(p instanceof Product)){
              throw new IllegalArgumentException();
          } 
          
          add(products, p);
      }
      
      /**
       * Sets the products array to the given array.
       * @param products A Product[] array.
       */
      public final void setProductList(Product[] products){
          if(products == null){
              throw new NullPointerException();
          }
          this.products = products;
      }
     
      
      
      //private methods
      
      /**
       * Adds an object to the specified array. Resizes the array if necessary.
       * @param array 
       * @param o 
       */
    private void add(Object[] array, Object o){
        if(o == null){
            throw new NullPointerException();
        }
        if(array[array.length - 1] == null){
            expandArray(array);
        }
        array[array.length - 1] = o;
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
