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
    
    private int customerID;
    private String firstName;
    private String lastName;
    
    private Discount discount; //preferred customers receive an additional discount
    
    
    public Customer(int customerID, String fName, String lName, Discount discount){
        setCustomerID(customerID);
        setFirstName(fName);
        setLastName(lName);
        setDiscount(discount);
    }

    public final int getCustomrID() {
        return customerID;
    }

    public final String getFirstName() {
       return firstName;
    }

    public final String getLastName() {
        return lastName;
    }
    
    public final Discount getDiscount(){
        return discount;
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
    
    public final void setDiscount(Discount d){
        if(d == null){
            throw new NullPointerException();
        }
        discount = d;
    }
    
    
}
