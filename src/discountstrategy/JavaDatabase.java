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
    private final String CUST_ID_ERR = "Please enter a valid customer ID";
    private final String PROD_ID_ERR = "Please enter a valid product ID";
    
     private USAddress garyAddress = new USAddress("Gary Zivney", "21590 Davidson Drive", 
             "Waukesha", "WI", "53188");
    private Product[] products = 
        { new ClothingProduct(1000, "Women's black boots",79.99, new  FlatRateDiscount(.1))
         ,new ClothingProduct(1001, "Men's black boots", 64.99, new FlatRateDiscount(.1))
         ,new ClothingProduct(1002, "Women's brown boots",79.99, new FlatRateDiscount(.15))
         ,new ClothingProduct(1003, "Women's dress shoes", 59.99, new NoDiscount())
         ,new ClothingProduct(1004, "Men's dress shoes", 39.99, new NoDiscount())};
    private Customer[] customers = {  new Customer(100, "Gary", "Zivney", garyAddress, garyAddress)
                                    , new Customer(101, "Becca", "Emrick")
                                    , new Customer(102, "Ife", "Van Deslunt")};
    
    
    /**
     * Constructor that creates the customer and product arrays.
     */
    public JavaDatabase(){    
    
    }
    
    
        /**
         * Returns the customer with the given customerID, or null if not found.
         * @param customerID An integer greater than or equal to 0
         * @return 
         */
        @Override
        public final Customer findCustomer(int customerID) {
           if(customerID < 0){
               throw new IllegalArgumentException(CUST_ID_ERR);
           }
           for(Customer customer : customers){
               if(customer.getCustomrID() == customerID){
                   return customer;
               }
           }
           return null;
        }
        
        
        /**
          * Returns the product with the given productID, or null if not found.
          * @param productID
          * @return 
          */
        @Override
        public final Product findProduct(int productID){
            if(productID < 0){
                throw new IllegalArgumentException(PROD_ID_ERR);
            } 
            for(Product prod : products){
                if(prod.getItemNumber() == productID){
                    return prod;
                }
            }
            
            return null;
            
      }
        
        
        //additional methods to provide flexibility for adding customers/products
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
