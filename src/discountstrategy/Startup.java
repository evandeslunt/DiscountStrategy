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
       
       Product shirt = new ClothingProduct(1, "black TShirt, short", 14.99, tenPercentOff);
       Product jeans = new ClothingProduct(2, "Women's blue jeans", 39.99, tenPercentOff);
       LineItem lineOne = new LineItem(shirt, 4);
       LineItem lineTwo = new LineItem(jeans, 1);
       LineItem[] items = {lineOne, lineTwo};
       Receipt r = new RegisterReceipt(ife, items);
       
       shirt.setDiscountType(new QtyDiscount(.15, 3, lineOne.getQuantity()));
       
       r.printReceipt();
      
        
        
    }
    
}
