
package discountstrategy;
import java.text.*;
import java.util.*;

/**
 * A Receipt formatted for an in-store purchase.
 * @author Liz Ife Van Deslunt
 */
public class PrintedReceipt implements ReceiptStrategy{
    //errors
    private final static String QTY_ERR = "Please supply a quantity purchased greater than 0.";
    private final static String DB_ERR = "Please supply a valid database.";
    private final static String CUST_NOT_FOUND_ERR = "That customer ID is not on file.";
    private final static String PROD_NOT_FOUND_ERR = "That product ID is not on file.";
    
    //constants for formatting/printing receipt
    private final String headerRow = "ITEM #\t DESCR\t\t UNIT PRICE\t "
            + "QTY\t EXT.PRICE\t DISCOUNT\t TOTAL";
    private final String tabsForTotals = "\nGRAND TOTALS: \t\t\t\t\t" ;
    private final int INIT_LINE_ITEM_ARRAY_SIZE = 1;
    private final String DATE_FORMAT = "MM/dd/yyyy hh:mm aa";
    
    private NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
    private NumberFormat percentFormatter = NumberFormat.getPercentInstance();
    private Calendar transDate;
    
    //global variables
    private Customer customer;
    private LineItem[] lineItems;
    private DatabaseStrategy db;
    
    /**
     * Constructor that accepts a customer ID and uses the default database.
     * @param customerID The customer making the purchase.
     */
    public PrintedReceipt(int customerID){
        setDatabase(new JavaDatabaseWithCollection()); 
        setCustomer(customerID);
        lineItems = new LineItem[INIT_LINE_ITEM_ARRAY_SIZE];
        transDate = Calendar.getInstance(); //set the transaction date to now.
        
    }
    
    /**
     * Constructor that accepts a database and customer ID.
     * @param customerID - The customer making the purchase.
     * @param db - The database to use.
     */
    public PrintedReceipt(int customerID, DatabaseStrategy db){
        setDatabase(db);
        setCustomer(customerID);
        lineItems = new LineItem[INIT_LINE_ITEM_ARRAY_SIZE];
        transDate = Calendar.getInstance(); //set the transaction date to now.
    }
    
    //getters  
    public final LineItem[] getLineItemArray(){
        return lineItems;
    }
    
    
    //setters
    
    /**
     * Changes the database used by this receipt.
     * @param db 
     */
    @Override
    public final void setDatabase(DatabaseStrategy db) throws NullPointerException{
        if(db == null){
            throw new NullPointerException(DB_ERR);
        }
        this.db = db;
    }
    
    @Override
    public final void setCustomer(int customerID) throws IllegalArgumentException, NotFoundException{
        if(!verifyCustomer(customerID)){
            throw new NotFoundException(CUST_NOT_FOUND_ERR);
        }
        customer = db.findCustomer(customerID);
    }
    
    
    @Override
    public final void addProductToReceipt(int productID, int qty) throws IllegalArgumentException, NotFoundException{
        if(!verifyProduct(productID)){
            throw new NotFoundException(PROD_NOT_FOUND_ERR);
        } 
        if(qty < 0){
            throw new IllegalArgumentException(QTY_ERR);
        }
        
        Product product = db.findProduct(productID);
        
        //resize array if it's full
        if(lineItems[lineItems.length - 1 ] != null){
            lineItems = resizeLineItemArray();
        }
        //add to array
        addProductToLineItems(product, qty);
    }
    
     /**
      * Creates the text of the receipt
      * @return 
      */
    @Override
    public String getReceipt(){
         String printOut = "Customer: " + customer.getFirstName() + " " 
                + customer.getLastName() + "\nDate: " + getTransDateAsString();
      
        printOut = printOut + "\n" + headerRow;
        printOut = printOut + addLineItemsToPrintOut();
        printOut = printOut + addGrandTotals();
        return printOut;
    }
    
    //private methods
     
     private LineItem[] resizeLineItemArray(){
         LineItem[] temp = new LineItem[lineItems.length + 1];
         for(int i = 0; i < lineItems.length; i++){
             temp[i] = lineItems[i];
         }
         return temp;
     }
    
     /**
      * Adds a new LineItem to the end of the lineItems array.
      * @param prodID
      * @param qty 
      */
     private void addProductToLineItems(Product product, int qty){
         lineItems[lineItems.length - 1 ] = new LineItem(product, qty);
     }
     

    /**
     * Adds line items to the printout
     * @return 
     */
    private String addLineItemsToPrintOut(){
        String lines = "\n";
        for(int i = 0; i < lineItems.length; i++){
            LineItem curr = lineItems[i];
            lines = lines + 
                    curr.getProductNumber() + "\t" +
                    curr.getProdDescription() + "\t" +
                    moneyFormatter.format(curr.getUnitPrice()) + "\t" +
                    curr.getQuantity() + "\t" +
                    moneyFormatter.format(curr.getExtendedPrice()) + "\t\t" +
                    percentFormatter.format(curr.getDiscountRate()) + "\t\t" +
                    moneyFormatter.format(curr.getFinalPrice()) + "\n";
            
        }
        return lines;
    }
    
    /**
     * Sums the extended price, discount amount, and total owed, and formats 
     * as a string.
     * @return 
     */
    private String addGrandTotals(){
        double undiscountedTotal = 0;
        double finalTotal = 0;
        for(int i = 0; i < lineItems.length; i++){
            LineItem curr = lineItems[i];
            undiscountedTotal += curr.getExtendedPrice();
            finalTotal += curr.getFinalPrice();
        }
        
        double amountSaved = undiscountedTotal - finalTotal;
        String totals =  tabsForTotals + moneyFormatter.format(undiscountedTotal) 
                + "\t\t" + moneyFormatter.format(amountSaved) + "\t\t"
                + moneyFormatter.format(finalTotal);
        
        return totals;
    }
    
    /**
     * Returns the transaction date as a formatted string.
     * @return 
     */
    private String getTransDateAsString(){
        String formattedDate = DateUtilities.formatDate(transDate, DATE_FORMAT);
        return formattedDate;
    }
    
    /**
     * Verifies that the customerID matches a customer in the database.
     * @param customerID - The customerID of the customer making the purchase.
     * @return True if the customer is in the database; false otherwise.
     */
    private boolean verifyCustomer(int customerID){
        try{
            if (db.findCustomer(customerID) == null){
                return false;
            } else{
                return true;
            }
        } catch(IllegalArgumentException e){
            return false;
        } 
    }
    
    /**
     * Verifies that the productID matches a product in the database.
     * @param productID - The productID.
     * @return True if the product is in the database; false otherwise.
     */
    private boolean verifyProduct(int productID){
        try{
            if (db.findProduct(productID) == null){
                return false;
            } else{
                return true;
            }
        } catch(IllegalArgumentException e){
            return false;
        }
    }
   
}
