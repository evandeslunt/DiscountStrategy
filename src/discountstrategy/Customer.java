
package discountstrategy;

/**
 * A Customer class that holds information such as name, customer ID, and address.
 * 
 * @author Liz Ife Van Deslunt
 */
public class Customer {
    // error messages
    private final String ID_ERR = "Please enter an ID greater than 0.";
    private final String FIRST_NAME_ERR = "Please enter a first name.";
    private final String LAST_NAME_ERR = "Please enter a last name.";
    private final String ADDR_ERR = "Please enter a valid address.";
    
    // constants
    private final int INIT_ARRAY_SIZE = 1;
    
    // global variables
    private int customerID;
    private String firstName;
    private String lastName;
    private AddressStrategy[] shippingAddresses = new AddressStrategy[INIT_ARRAY_SIZE];
    private AddressStrategy[] billingAddresses = new AddressStrategy[INIT_ARRAY_SIZE];
    
    
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
    public Customer(int customerID, String fName, String lName, AddressStrategy shipTo, 
            AddressStrategy billTo){
        setCustomerID(customerID);
        setFirstName(fName);
        setLastName(lName);
        addShippingAddress(shipTo);
        addBillingAddress(billTo);
    }
    
     /**
     * Constructor with multiple ship-to and bill-to addresses
     */
    public Customer(int customerID, String fName, String lName, AddressStrategy[] shipTo, 
            AddressStrategy[] billTo){
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
    
    public final AddressStrategy[] getShippingAddresses(){
        return shippingAddresses;
    }
    
    public final AddressStrategy[] getBillingAddresses(){
        return billingAddresses;
    }

    
    // setters
    
    public final void setCustomerID(int id) throws IllegalArgumentException{
       if(id <= 0){
           throw new IllegalArgumentException(ID_ERR);
       }
       this.customerID = id;
    }
    
    public final void setFirstName(String firstName) throws IllegalArgumentException, NullPointerException{
       if(firstName == null ){
           throw new NullPointerException(FIRST_NAME_ERR);
       } else if (firstName.length() == 0){
           throw new IllegalArgumentException(FIRST_NAME_ERR);
       }
       this.firstName = firstName;
    }
    
    public final void setLastName(String lastName) throws IllegalArgumentException, NullPointerException{
        if(lastName == null ){
           throw new NullPointerException(LAST_NAME_ERR);
       } else if (lastName.length() == 0){
           throw new IllegalArgumentException(LAST_NAME_ERR);
       }
       this.lastName = lastName;
    }
    
    public final void addShippingAddress(AddressStrategy address) throws  NullPointerException{
        if(address == null){
            throw new NullPointerException(ADDR_ERR);
        }
        add(shippingAddresses, address);
    }
    
    public final void addBillingAddress(AddressStrategy address) throws NullPointerException{
        if(address == null){
            throw new NullPointerException(ADDR_ERR);
        }
        add(billingAddresses, address);
    }
    
    
    //private helper methods
    
      /**
       * Adds an object to the specified array. Resizes the array if necessary.
       * @param array 
       * @param o 
       */
    private void add(AddressStrategy[] array, AddressStrategy o) throws NullPointerException{
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
    private AddressStrategy[] expandArray(AddressStrategy[] array) throws NullPointerException{
        if(array == null){
            throw new NullPointerException();
        }
        AddressStrategy[] tmp = new AddressStrategy[array.length + 1];
        
        for(int i = 0; i < array.length; i++){
            tmp[i] = array[i];
        }
        
        return tmp;
    }
    
}
