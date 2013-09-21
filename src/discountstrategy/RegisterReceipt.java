/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;
import java.text.*;

/**
 *
 * @author Liz Ife Van Deslunt
 */
public class RegisterReceipt implements Receipt{
    private final String headerRow = "ITEM #\t DESCR\t\t UNIT PRICE\t "
            + "QTY\t TOTAL\t DISCOUNT RATE\t FINAL TOTAL";
    private final String tabsForTotals = "\nGRAND TOTALS: \t\t\t\t\t" ;
    
    private NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
    private NumberFormat percentFormatter = NumberFormat.getPercentInstance();
    private Customer customer;
    private LineItem[] lineItems;
    
    
    public RegisterReceipt(Customer c, LineItem[] l){
        setCustomer(c);
        setLineItems(l);
    }
    
    @Override
    public final void printReceipt(){
        String printOut = buildPrintOut();
        System.out.println(printOut);
    }
    
    @Override
    public final void setCustomer(Customer c){
        if(c == null){
            throw new NullPointerException();
        }
        customer = c;
    }
    
    @Override
    public final void setLineItems(LineItem[] l){
        if(l == null){
            throw new NullPointerException();
        } else if (l.length == 0){
            throw new IllegalArgumentException();
        }
        lineItems = l;
    }
    
    
    //private methods
    
    private String buildPrintOut(){
         String printOut = "Customer: " + customer.getFirstName() + " " 
                + customer.getLastName();
      
        printOut = printOut + "\n" + headerRow;
        
        //add line items
        printOut = printOut + addLineItemsToPrintOut();
        
        //create grand totals
        printOut = printOut + addGrandTotals();
        return printOut;
    }
    
    private String addLineItemsToPrintOut(){
        String lines = "\n";
        for(int i = 0; i < lineItems.length; i++){
            LineItem curr = lineItems[i];
            lines = lines + 
                    curr.getProductNumber() + "\t" +
                    curr.getProdDescription() + "\t" +
                    moneyFormatter.format(curr.getUnitPrice()) + "\t" +
                    curr.getQuantity() + "\t" +
                    moneyFormatter.format(curr.getUndiscountedPrice()) + "\t" +
                    percentFormatter.format(curr.getDiscountRate()) + "\t\t" +
                    moneyFormatter.format(curr.getFinalPrice()) + "\n";
            
        }
        return lines;
    }
    
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
                + "\t\t" + moneyFormatter.format(amountSaved) + "\t"
                + moneyFormatter.format(finalTotal);
        
        return totals;
    }
   
}
