
package discountstrategy;

import java.util.*;

/**
 * A Java-based database that uses Collections to store information (instead of
 * arrays).
 * @author Liz Ife Van Deslunt
 */
public class JavaDatabaseWithCollection implements DatabaseStrategy{

    // error messages
    private final static String CUST_ID_ERR = "Please enter a valid customer ID";
    private final static String PROD_ID_ERR = "Please enter a valid product ID";
    private final static String CUST_ENTRY_ERR = "Please supply a valid customer.";
    private final static String PROD_ENTRY_ERR = "Please supply a valid product.";
    private final static String CUST_NOT_FOUND = "That customer was not found.";
    private final static String PROD_NOT_FOUND = "That product was not found.";
    
    private Map<Integer,Product> products;
    private Map<Integer,Customer> customers;
    
    /**
     * Default constructor creates the database with data.
     */
    public JavaDatabaseWithCollection(){
        initializeProducts();
        initializeCustomers();
    }
    
    /**
     * Adds a customer to the database.
     * @param customer The customer to add.
     * @throws NullPointerException If the customer object passed in is null.
     */
    @Override
    public final void addCustomer(Customer customer) throws NullPointerException {
        if(customer==null){
            throw new NullPointerException(CUST_ENTRY_ERR);
        }
        Integer key = customer.getCustomrID();
        customers.put(key, customer);
    }

    /**
     * Returns the customer having the given customerID. If the customer is not
     * found, throws a NotFoundException.
     * @param customerID The cusomterID of the customer to be found.
     * @return The customer with the corresponding customerID.
     * @throws IllegalArgumentException If customerID is less than 0.
     * @throws NotFoundException If there is no customer in the database with
     * the given customerID.
     */
    @Override
    public final Customer findCustomer(int customerID) throws IllegalArgumentException, NotFoundException {
        if(customerID < 0){
            throw new IllegalArgumentException(CUST_ID_ERR);
        } else if (!customers.containsKey(customerID)){
            throw new NotFoundException(CUST_NOT_FOUND);
        } else {
            return customers.get(customerID);
        }
    }
    
    /**
     * Adds a product to the Product Map, using the productID as an Integer key.
     * @param product - The product to add.
     * @throws NullPointerException If the product is null.
     */
    @Override
    public final void addProduct(Product product) throws NullPointerException {
        if(product==null){
            throw new NullPointerException(PROD_ENTRY_ERR);
        } 
        Integer key = product.getProductID();
        products.put(key, product);
    }

    /**
     * Returns the product with the given key, if it is in the Map, otherwise
     * throws a NotFoundException.
     * @param productID The productID of the product to find.
     * @return The product with the given productID.
     * @throws IllegalArgumentException If the productID is less than 0.
     * @throws NotFoundException If there is no product with the given ID in the 
     * database.
     */
    @Override
    public final Product findProduct(int productID) throws IllegalArgumentException, NotFoundException {
        if(productID < 0){
            throw new IllegalArgumentException(PROD_ID_ERR);
        }
        if(!products.containsKey(productID)){
            throw new NotFoundException(PROD_NOT_FOUND);
        }
        return products.get(productID);
    }
    
    /**
     * Initializes the products in the database based on hard-coded data. In a 
     * later version, I would lIke to read from a file.
     */
    private void initializeProducts(){
        //Discounts
        DiscountFactory.DISCOUNT_TYPE flatRate = DiscountFactory.DISCOUNT_TYPE.FLAT_RATE;
        DiscountFactory.DISCOUNT_TYPE quantity = DiscountFactory.DISCOUNT_TYPE.QUANTITY;
         
        DiscountStrategy flatRateTen = DiscountFactory.getDiscount(flatRate, .1, 1);
        DiscountStrategy flatRateFifteen = DiscountFactory.getDiscount(flatRate, .15, 1);
        DiscountStrategy flatRateTwenty = DiscountFactory.getDiscount(flatRate, .2, 1);
        DiscountStrategy quantityFifty = DiscountFactory.getDiscount(quantity, .5, 5);
        
        //prodcuts
        ProductFactory.PROD_TYPE clothing = ProductFactory.PROD_TYPE.CLOTHING;
        
        products = new HashMap<Integer,Product>();
        addProduct(ProductFactory.getProduct(clothing, "Blue Jeans\t", 34.95, flatRateTen));
        addProduct(ProductFactory.getProduct(clothing, "Fancy skirt\t", 39.95, flatRateFifteen));
        addProduct(ProductFactory.getProduct(clothing, "Dress Slacks\t", 45.95));
        addProduct(ProductFactory.getProduct(clothing, "Khakis\t\t", 29.95, flatRateTwenty));
        addProduct(ProductFactory.getProduct(clothing, "Purple Polo Shirt", 19.95, quantityFifty));
        addProduct(ProductFactory.getProduct(clothing, "Blue Polo Shirt", 19.95, quantityFifty));
        
    }
    
    /**
     * Initializes the customers in the database based on hard-coded data. In a
     * future version, I would like to read from a file.
     */
    private void initializeCustomers(){
        AddressStrategy addr1 = new USAddress("Fyoder Dostoevsky","217 North Street", "Waukesha", "WI", "53188");
        AddressStrategy addr2 = new USAddress("Aleksandr Pushkin","314 Main Street", "Waukesha", "WI", "53188");
        AddressStrategy addr3 = new USAddress("Fyoder Dostoevsky","47 E. Gorham Street", "Madison", "WI", "53703");
        AddressStrategy addr4 = new USAddress("Ada Lovelace","1 Kinikinnic Ave", "Milwaukee", "WI", "53202");
        
        customers = new HashMap<Integer,Customer>();
        addCustomer(CustomerFactory.getCustomerWithAddress("Fyoder", "Dostoevsky", addr1, addr1));    
        addCustomer(CustomerFactory.getCustomerWithAddress("Aleksandr", "Pushkin", addr2, addr3));
        addCustomer(CustomerFactory.getCustomerWithAddress("Ada", "Lovelace", addr4, addr4));
    }
    
}
