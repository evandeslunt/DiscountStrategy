/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author Liz Ife Van Deslunt
 */
public class RegisterReceipt implements Receipt{
    private final String headerRow = "ITEM #\t DESCR\t UNIT PRICE\t QTY\t"
            + "DISCOUNT RATE\t TOTAL";
    
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
        
        printOut = printOut + addLineItemsToPrintOut(printOut);
        
        return printOut;
    }
    
    private String addLineItemsToPrintOut(String printOut){
        System.out.println("-----------------");
        for(int i = 0; i < lineItems.length; i++){
            LineItem curr = lineItems[i];
            printOut = printOut + 
                    curr.getProductNumber() + "\t" +
                    curr.getProdDescription() + "\t" +
                    curr.getUndiscountedPrice() + "\t" +
                    curr.getDiscountRate() + "\t" +
                    curr.getFinalPrice() + "\n";
            
        }
        return printOut;
    }
   
}
