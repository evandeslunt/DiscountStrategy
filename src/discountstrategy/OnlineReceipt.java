/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

import java.text.NumberFormat;

/**
 *
 * @author Liz Ife Van Deslunt
 */
public class OnlineReceipt implements Receipt{
    private final String CUST_NUM_ERR = "Please enter a valid customer ID.";
    private final String MISSING_ADDRESS = "Please enter an ID for shipping and billing addresses";
    
    private final String headerRow = "ITEM #\t DESCR\t\t UNIT PRICE\t "
            + "QTY\t EXT.PRICE\t DISCOUNT\t TOTAL";
    private final String tabsForTotals = "\nGRAND TOTALS: \t\t\t\t\t" ;
    private final int INIT_LINE_ITEM_ARRAY_SIZE = 1;
    
    private NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
    private NumberFormat percentFormatter = NumberFormat.getPercentInstance();
    
    private Customer customer;
    private LineItem[] lineItems;
    private Database db;
    private int shipAddrID;
    private int billAddrID;
    
    public OnlineReceipt(int customerID, int shipAddrID, int billAddrID){
        setDatabase(new JavaDatabase()); // set the database here. we can change it later with the setDatabase method if we need to
        setCustomer(customerID);
        setShipAddrID(shipAddrID);
        setBillAddrID(billAddrID);
        lineItems = new LineItem[INIT_LINE_ITEM_ARRAY_SIZE];
        
    }
    
    //getters
    @Override
    public final Database getDatabase(){
        return db;
    }
    
    public final LineItem[] getLineItemArray(){
        return lineItems;
    }
    
    
    //setters
    @Override
    public final void setDatabase(Database db){
        this.db = db;
    }
    
    @Override
    public final void setCustomer(int customerID){
        if(customerID < 0){
            throw new IllegalArgumentException(CUST_NUM_ERR);
        }
        customer = db.findCustomer(customerID);
    }
    
    public final void setShipAddrID(int addrNum){
        if(addrNum < 0){
            throw new IllegalArgumentException(MISSING_ADDRESS);
        }
        this.shipAddrID = addrNum;
    }
    
    public final void setBillAddrID(int addrNum){
        if(addrNum < 0){
            throw new IllegalArgumentException(MISSING_ADDRESS);
        }
        this.billAddrID = addrNum;
    }
    
    @Override
    public final void addProductToReceipt(int productID, int qty){
        //resize array if it's full
        if(lineItems[lineItems.length - 1 ] != null){
            lineItems = resizeLineItemArray();
        }
        //add to array
        addProductToLineItems(productID, qty);
    }
    
     @Override
    public final void printReceipt(){
        String printOut = buildPrintOut();
        System.out.println(printOut);
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
     private void addProductToLineItems(int prodID, int qty){
         lineItems[lineItems.length - 1 ] = new LineItem(db.findProduct(prodID), qty);
     }
     
     /**
      * Creates the text of the receipt.
      * @return 
      */
    private String buildPrintOut(){
        String printOut = addCustomerInfo();
      
        printOut = printOut + "\n" + headerRow;
        printOut = printOut + addLineItemsToPrintOut();
        printOut = printOut + addGrandTotals();
        return printOut;
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
                    moneyFormatter.format(curr.getUndiscountedPrice()) + "\t\t" +
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
            undiscountedTotal += curr.getUndiscountedPrice();
            finalTotal += curr.getFinalPrice();
        }
        
        double amountSaved = undiscountedTotal - finalTotal;
        String totals =  tabsForTotals + moneyFormatter.format(undiscountedTotal) 
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
                 + customer.getShippingAddresses()[shipAddrID].toString();
         printOut = printOut + "\nBilling Address:\n" 
                 + customer.getBillingAddresses()[billAddrID].toString();
         return printOut;
    }
    
}
