/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 * A "fake database" that stores products and customers in arrays.
 * 
 * @author Liz Ife Van Deslunt
 */
public class JavaDatabase implements DatabaseStrategy{
    // error messages
    private final static String CUST_ID_ERR = "Please enter a valid customer ID";
    private final static String PROD_ID_ERR = "Please enter a valid product ID";
    private final static String CUST_ENTRY_ERR = "Please supply a valid customer.";
    private final static String PROD_ENTRY_ERR = "Please supply a valid product.";
    private final static String CUST_ARRAY_ERR = "Please supply a valid Customer array.";
    private final static String PROD_ARRAY_ERR = "Please supply a valid Product array.";
    private final static String CUST_NOT_FOUND = "That customer was not found.";
    private final static String PROD_NOT_FOUND = "That product was not found.";
    
    private Product[] products;
    private final static int INIT_ARRAY_SIZE = 10;
    
    // hard-coded data
     private USAddress garyShipAddress = new USAddress("Gary Zivney", "123 Easy Street", 
             "Waukesha", "WI", "53188");
     private USAddress garyBillAddress = new USAddress("Gary Zivney", "456 University Ave",
             "Madison", "WI", "53703");
//    private Product[] products =
//        { new ClothingProduct(1000, "Women's black boots",79.99, new  FlatRateDiscount(.1))
//         ,new ClothingProduct(1001, "Men's black boots", 64.99, new FlatRateDiscount(.1))
//         ,new ClothingProduct(1002, "Women's brown boots",79.99, new FlatRateDiscount(.15))
//         ,new ClothingProduct(1003, "Women's dress shoes", 59.99, new NoDiscount())
//         ,new ClothingProduct(1004, "Men's dress shoes", 39.99, new NoDiscount())};
    private Customer[] customers = {  new Customer(100, "Gary", "Zivney", garyShipAddress, garyBillAddress)
                                    , new Customer(101, "Becca", "Emrick")
                                    , new Customer(102, "Liz", "Van Deslunt")};
    
    
    /**
     * Constructor that creates the pre-populated customer and product arrays.
     */
    public JavaDatabase(){    
        initializeProductsArray();
        initializeCustomerArray();
    }
    
    
    /**
     * Returns the customer with the given customerID, or throws exception if
     * the customer was not found.
     * @param customerID An integer greater than or equal to 0
     * @return The Customer object matching the customerID, or null if the
     * Customer is not found.
     */
    @Override
    public final Customer findCustomer(int customerID) throws IllegalArgumentException{
       if(customerID < 0){
           throw new IllegalArgumentException(CUST_ID_ERR);
       }
       //searches the customer array for the customerID and returns the customer
       //when it's found.
       for(Customer customer : customers){
           if(customer.getCustomrID() == customerID){
               return customer;
           }
       }
       //if the customer isn't found, return null
       return null;
    }


    /**
      * Returns the product with the given productID, or null if not found.
      * @param productID
      * @return The Product object matching the given productID, or null if the
      * product isn't found.
      */
    @Override
    public final Product findProduct(int productID) throws IllegalArgumentException{
        if(productID < 0){
            throw new IllegalArgumentException(PROD_ID_ERR);
        } 
        
        //searches the product array for the product ID and returns the product
        //when it's found.
        for(Product prod : products){
            if(prod.getProductID() == productID){
                return prod;
            }
        }

        //if the product isn't found,return null
        return null;
  }

        /**
         * Adds a customer to the customer list.
         * @param c A Customer object.
         */
        @Override
        public final void addCustomer(Customer c) throws NullPointerException{
            if(c == null){
                throw new NullPointerException(CUST_ENTRY_ERR);
            }

            add(customers, c);
        }

//        /**
//         * Sets the customers array to the given array.
//         * @param customers A Customer[] array
//         */
//         public final void setCustomerList(Customer[] customers) throws NullPointerException{
//             if(customers == null){
//                 throw new NullPointerException();
//             }
//             this.customers = customers;
//         }


         /**
          * Adds a product to the product list.
          * @param p 
          */
        @Override
        public final void addProduct(Product p) throws NullPointerException{
            if(p == null){
                throw new NullPointerException(PROD_ENTRY_ERR);
            } 

            add(products, p);
        }

//        /**
//         * Sets the products array to the given array.
//         * @param products A Product[] array.
//         */
//        public final void setProductList(Product[] products) throws NullPointerException{
//            if(products == null){
//                throw new NullPointerException(PROD_ARRAY_ERR);
//            }
//            this.products = products;
//        }



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
      
      /**
       * Initializes the products array with hard-coded products.
       * Note: Ideally, this would be read from an input file.
       */
        private  void initializeProductsArray(){
            ProductFactory.PROD_TYPE clothing = ProductFactory.PROD_TYPE.CLOTHING;

            products = new Product[INIT_ARRAY_SIZE];
            addProduct(ProductFactory.getProduct(clothing, "Blue Jeans", 34.95));
            addProduct(ProductFactory.getProduct(clothing, "Fancy skirt", 39.95));
            addProduct(ProductFactory.getProduct(clothing, "Dress Slacks", 45.95));
            addProduct(ProductFactory.getProduct(clothing, "Khakis", 29.95));
            addProduct(ProductFactory.getProduct(clothing, "Purple Polo Shirt", 19.95));
            addProduct(ProductFactory.getProduct(clothing, "Blue Polo Shirt", 19.95));

        }
    
        private void initializeCustomerArray(){
            addCustomer(CustomerFactory.getInStoreCustomer("Caitlin", "Brown"));
        }
}
