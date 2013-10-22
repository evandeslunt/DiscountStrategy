
package discountstrategy;

/**
 * Cash register that handles input and output between the startup class and 
 * the receipt.
 * @author Liz Ife Van Deslunt
 */
public class Register {
    // error messages
    private final static String RECEIPT_ERR = "Please enter a valid receipt type.";
    
    // global variables
    private ReceiptStrategy receipt;
        
    /**
     * Constructor that initializes the receipt to PrintedReceipt
     * @param prodID
     * @param quantity 
     */
    public Register(int customerID){
        receipt = new PrintedReceipt(customerID);

    }


    //public methods

    public final void addProductToReceipt(int prodID, int quantity){        
        receipt.addProductToReceipt(prodID, quantity);
    }
    
    public final void setReceiptType(ReceiptStrategy receipt){
        if(receipt == null){
            throw new NullPointerException(RECEIPT_ERR);
        }
        this.receipt = receipt;
    }
    
    public final void printReceipt(){
        System.out.println(receipt.getReceipt());
    }
    
   
    
}
