
package discountstrategy;


/**
 * @author Liz Ife Van Deslunt
 */
public class Startup {
    
    public static void main(String[] args){
       
       Register reg = new Register(101);
       
       
       reg.addProductToReceipt(101, 3);
       reg.addProductToReceipt(102, 1);
       reg.addProductToReceipt(105, 5);
       
       reg.printReceipt();
       
       
        
    }
    
    
}
