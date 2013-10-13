
package discountstrategy;


/**
 * @author Liz Ife Van Deslunt
 */
public class Startup {
    
    public static void main(String[] args){
       
       
       Register reg = new Register(101);
       
       
       reg.addProductToReceipt(1000, 3);
       reg.addProductToReceipt(1001, 1);
       
       reg.printReceipt();
        
        
    }
    
}
