/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author Liz Ife Van Deslunt
 */
public class Customer {
    
    private final String ID_ERR = "Please enter an ID greater than 0.";
    private final String FIRST_NAME_ERR = "Please enter a first name.";
    private final String LAST_NAME_ERR = "Please enter a last name.";
    
    private final int INIT_ARRAY_SIZE = 1;
    
    private int customerID;
    private String firstName;
    private String lastName;
    private Address[] shippingAddresses = new Address[INIT_ARRAY_SIZE];
    private Address[] billingAddresses = new Address[INIT_ARRAY_SIZE];
    
    
    /**
     * Constructor without an address (e.g., for in-store customers)
     */
    public Customer(int customerID, String fName, String lName){
        setCustomerID(customerID);
        setFirstName(fName);
        setLastName(lName);
    }
    
    /**
     * Constructor with a single ship-to and single bill-to address
     */
    public Customer(int customerID, String fName, String lName, Address shipTo, 
            Address billTo){
        setCustomerID(customerID);
        setFirstName(fName);
        setLastName(lName);
        addShippingAddress(shipTo);
        addBillingAddress(billTo);
    }
    
     /**
     * Constructor with multiple ship-to and bill-to addresses
     */
    public Customer(int customerID, String fName, String lName, Address[] shipTo, 
            Address[] billTo){
        setCustomerID(customerID);
        setFirstName(fName);
        setLastName(lName);
        for(int i = 0; i < shipTo.length; i++){
            addShippingAddress(shipTo[i]);
        }
        for(int i = 0; i < billTo.length; i++){
            addBillingAddress(billTo[i]);
        }
    }

    // getters
    
    public final int getCustomrID() {
        return customerID;
    }

    public final String getFirstName() {
       return firstName;
    }

    public final String getLastName() {
        return lastName;
    }
    
    public final String getFullName(){
        return firstName + " " + lastName;
    }
    
    public final Address[] getShippingAddresses(){
        return shippingAddresses;
    }
    
    public final Address[] getBillingAddresses(){
        return billingAddresses;
    }

    
    // setters
    
    public final void setCustomerID(int id) {
       if(id <= 0){
           throw new IllegalArgumentException(ID_ERR);
       }
       this.customerID = id;
    }
    
    public final void setFirstName(String firstName) {
       if(firstName == null ){
           throw new NullPointerException(FIRST_NAME_ERR);
       } else if (firstName.length() == 0){
           throw new IllegalArgumentException(FIRST_NAME_ERR);
       }
       this.firstName = firstName;
    }
    
    public final void setLastName(String lastName) {
        if(lastName == null ){
           throw new NullPointerException(LAST_NAME_ERR);
       } else if (lastName.length() == 0){
           throw new IllegalArgumentException(LAST_NAME_ERR);
       }
       this.lastName = lastName;
    }
    
    public final void addShippingAddress(Address address){
        if(address == null){
            throw new NullPointerException();
        }
        add(shippingAddresses, address);
    }
    
    public final void addBillingAddress(Address address){
        if(address == null){
            throw new NullPointerException();
        }
        add(billingAddresses, address);
    }
    
    
    //private helper methods
    
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
