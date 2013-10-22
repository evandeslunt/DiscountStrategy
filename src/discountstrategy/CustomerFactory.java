
package discountstrategy;

/**
 * The CustomerFactory creates Customer objects for the database. It takes care 
 * of providing customerIDs and initialization.
 * 
 * @author Liz Ife Van Deslunt
 */
public class CustomerFactory {
    private static final String NAME_ERR = "Please supply a valid first name "
            + "and last name.";
    private static final String ADDR_ERR = "Please supply valid shipping and "
            + "billing addresses.";
    
    private static int lastCustID = 100;

    
     /**
      * Creates an "in-store" customer (one without a shipping/billing address)
      * @param firstName - The customer's first name
      * @param lastName - The customer's last name
      * @return A customer with the given first and last name, and no shipping
      * or billing addresses
      */
    public static Customer getInStoreCustomer(String firstName, String lastName){
        if(firstName==null || lastName == null){
            throw new NullPointerException(NAME_ERR);
        } else if (firstName.length() == 0 || lastName.length() == 0){
            throw new IllegalArgumentException(NAME_ERR);
        }
        lastCustID++;
        return new Customer(lastCustID, firstName, lastName); 
                
    }
    
    /**
     * Creates a customer with shipping and billing addresses.
     * @param firstName - The customer's first name.
     * @param lastName - The customer's last name.
     * @param shipAddr - The customer's shipping address
     * @param billAddr - The customer's billing address
     * @return A customer with the given first name, last name, and addresses.
     */
    public static Customer getCustomerWithAddress(String firstName, String lastName,
            AddressStrategy shipAddr, AddressStrategy billAddr){
        if(firstName==null || lastName == null){
            throw new NullPointerException(NAME_ERR);
        } else if (firstName.length() == 0 || lastName.length() == 0){
            throw new IllegalArgumentException(NAME_ERR);
        }
        if(shipAddr == null || billAddr == null){
            throw new NullPointerException(ADDR_ERR);
        } 
        
        AddressStrategy[] shipAddrArray = {shipAddr};
        AddressStrategy[] billAddrArray = {billAddr};
        
        lastCustID++;
        return new Customer(lastCustID, firstName, lastName, shipAddrArray, 
                billAddrArray); 
    }
}
