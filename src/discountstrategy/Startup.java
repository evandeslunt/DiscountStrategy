/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *scountstrategy;

/**
 * @author Liz Ife Van Deslunt
 */
public class Startup {
    
    public static void main(String[] args){
       Customer ife = new Customer(1, "Ife", "Zivney", new NoDiscount());
       Customer ige = new Customer(2, "Lexie", "DuBernard", new NoDiscount());
       Customer gary = new Customer(3, "Gary", "Zivney", new NoDiscount());
       Customer[] customerList = {ife, ige, gary};
       
       Discount tenPercentOff = new FlatRateDiscount (.1);
       
       Product shirt = new ClothingProduct(1, "Black T-Shirt, short", 14.99, tenPercentOff);
       Product jeans = new ClothingProduct(2, "Women's blue jeans", 39.99, tenPercentOff);
       Product boots = new ClothingProduct(3, "Awesome black boots", 35.95, tenPercentOff);
       Product[] productList = {shirt, jeans, boots};
       
       
       Database db = new JavaDatabase(productList, customerList);
       Register reg = new Register(db, 2);
       
       reg.addProductToReceipt(1, 3);
       reg.addProductToReceipt(2, 1);
       reg.addProductToReceipt(3, 1);
       
       
       
       LineItem[] lines = reg.getLineItems();
       System.out.println(lines.length);
       
       for(int i = 0; i < lines.length; i++){
           System.out.println(lines[i].getQuantity() + " of " + lines[i].getProdDescription());
       }
       
        
        
    }
    
}
