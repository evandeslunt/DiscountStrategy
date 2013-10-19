
package discountstrategy;

import java.text.NumberFormat;
import java.util.*;

/**
 * Formats the receipt for an online order, which includes a shipping/billing 
 * address.
 * @author Liz Ife Van Deslunt
 */
public class OnlineReceipt implements ReceiptStrategy{
    // error messages
    private final static String SHIP_ADDR_ERR = "Please enter an ID for shipping address.";
    private final static String BILL_ADDR_ERR = "Please enter an ID for the billing address.";
    private final static String QTY_ERR = "Please supply a quantity purchased greater than 0.";
    private final static String DB_ERR = "Please supply a valid database.";
    private final static String CUST_NOT_FOUND_ERR = "That customer ID is not on file.";
    private final static String PROD_NOT_FOUND_ERR = "That product ID is not on file.";
    
    // constants
    private final String HEADER_ROW = "ITEM #\t DESCR\t\t UNIT PRICE\t "
            + "QTY\t EXT.PRICE\t DISCOUNT\t TOTAL";
    private final String TABS_FOR_TOTALS = "\nGRAND TOTALS: \t\t\t\t\t" ;
    private final int INIT_LINE_ITEM_ARRAY_SIZE = 1;
    private final String DATE_FORMAT = "MM/dd/yyyy hh:mm aa";
    
    // global variables
    private NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
    private NumberFormat percentFormatter = NumberFormat.getPercentInstance();
    private Calendar transDate;
    
    private Customer customer;
    private LineItem[] lineItems;
    private DatabaseStrategy db;
    private int shipAddrID;
    private int billAddrID;
    
    public OnlineReceipt(int customerID, int shipAddrID, int billAddrID){
        setDatabase(new JavaDatabase()); // set the database here. we can change it later with the setDatabase method if we need to
        setCustomer(customerID);
        setShipAddrID(shipAddrID);
        setBillAddrID(billAddrID);
        lineItems = new LineItem[INIT_LINE_ITEM_ARRAY_SIZE];
        transDate = Calendar.getInstance(); //sets the transaction date to now.
        
    }
    
    //getters
    
    public final LineItem[] getLineItemArray(){
        return lineItems;
    }
    
    public final Customer getCustomer(){
        return customer;
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
    
    /**
     * Sets the customer completing the transaction.
     * 
     * @param customerID a
     */
    @Override
    public final void setCustomer(int customerID) throws IllegalArgumentException{
        if(!verifyCustomer(customerID)){
            throw new NotFoundException(CUST_NOT_FOUND_ERR);
        }
        customer = db.findCustomer(customerID);
    }
    
    /**
     * Changes the shipping address ID used by this receipt.
     * 
     * @param addrNum 
     */
    public final void setShipAddrID(int addrID) throws IllegalArgumentException{
        if(addrID < 0){
            throw new IllegalArgumentException(SHIP_ADDR_ERR);
        }
        this.shipAddrID = addrID;
    }
    
    /**
     * Changes the billing address ID used by this receipt.
     * 
     * @param addrID 
     */
    public final void setBillAddrID(int addrID) throws IllegalArgumentException{
        if(addrID < 0){
            throw new IllegalArgumentException(BILL_ADDR_ERR);
        }
        this.billAddrID = addrID;
    }
    
    /**
     * Adds a product to the receipt's line item list.
     * 
     * @param productID
     * @param qty The number of the product purchased.
     */
    @Override
    public final void addProductToReceipt(int productID, int qty) throws NotFoundException, IllegalArgumentException{
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
      * Gets the customer's receipt as a formatted String.
      * 
      * @return The receipt as a formatted String.
      */
    @Override
    public final String getReceipt(){
        String printOut = addCustomerInfo() 
               + "\nOrder Date: " + getTransDateAsString();;
      
        printOut = printOut + "\n" + HEADER_ROW;
        printOut = printOut + addLineItemsToPrintOut();
        printOut = printOut + addGrandTotals();
        return printOut;
    }
    
    //private methods
     
     /**
      * Adds one slot to the LineItem[] array.
      * @return 
      */
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
     private void addProductToLineItems(Product product, int qty) {
         lineItems[lineItems.length - 1 ] = new LineItem(product, qty);
     }
     

    
    /**
     * Adds line items to the printout.
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
        String totals =  TABS_FOR_TOTALS + moneyFormatter.format(undiscountedTotal) 
                + "\t\t" + moneyFormatter.format(amountSaved) + "\t\t"
                + moneyFormatter.format(finalTotal);
        
        return totals;
    }
    
    /**
     * Adds customer's name and shipping/billing address to the printout.
     * @return 
     */
    private String addCustomerInfo(){
         String printOut = "Customer: " + customer.getFullName();
         printOut = printOut + "\nShipping Address:\n" 
                 + customer.getShippingAddresses()[shipAddrID].getFormattedAddress();
         printOut = printOut + "\nBilling Address:\n" 
                 + customer.getBillingAddresses()[billAddrID].getFormattedAddress();
         return printOut;
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
