/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author Liz Ife Van Deslunt
 */
public class Startup {
    
    public static void main(String[] args){
       Customer ife = new Customer(1, "Ife", "Zivney", new NoDiscount());
       Discount tenPercentOff = new FlatRateDiscount (.1);
       Discount fifteenPercentOff = new FlatRateDiscount(.15);
       Product shirt = new ClothingProduct(1, "Short-sleeved shirt, black", 14.99, tenPercentOff);
       Product jeans = new ClothingProduct(2, "Women's blue jeans", 39.99, tenPercentOff);
       LineItem lineOne = new LineItem(shirt, 2);
       LineItem lineTwo = new LineItem(jeans, 1);
       LineItem[] items = {lineOne, lineTwo};
       Receipt r = new RegisterReceipt(ife, items);
       
       r.printReceipt();
      
        
        
    }
    
}
