
package discountstrategy;


/**
 * @author Liz Ife Van Deslunt
 */
public class Startup {
    
    public static void main(String[] args){
       
       
       Register reg = new Register(101);
       
       
       reg.addProductToReceipt(101, 3);
       reg.addProductToReceipt(102, 1);
       
       reg.printReceipt();
       
       
        
//        DiscountFactory factory = new DiscountFactory();
//        try{
//            DiscountStrategy disc = 
//                factory.getDiscount(DiscountFactory.DISCOUNT_TYPE.FLAT_RATE, .5, 1);
//            System.out.println("I created a discount of " +disc.getDiscountRate());
//
//            disc = factory.getDiscount(DiscountFactory.DISCOUNT_TYPE.QUANTITY, .5, 4);
//
//            System.out.println("I created a discount of " +disc.getDiscountRate());
//        } catch(NullPointerException e){
//            System.out.println("THERE WAS AN ERROR: " + e.getMessage());
//        } catch(IllegalArgumentException e){
//            System.out.println("THERE WAS AN INPUT ERROR: " + e.getMessage());
//        }
//        
//        ProductFactory prodFact = new ProductFactory();
//        try{
//            Product shirt = prodFact.getProduct(ProductFactory.PROD_TYPE.CLOTHING, "Shirt", 15.99, new NoDiscount());
//            Product pants = prodFact.getProduct(ProductFactory.PROD_TYPE.CLOTHING, "Pants", 29.99, new NoDiscount());
//            System.out.println(shirt.getDescription());
//            System.out.println(pants.getDescription());
//
//        } catch(NullPointerException e){
//            System.out.println("THERE WAS AN ERROR: " + e.getMessage());
//        } catch(IllegalArgumentException e){
//            System.out.println("THERE WAS AN INPUT ERROR: " + e.getMessage());
//        }
        
    }
    
    
}
