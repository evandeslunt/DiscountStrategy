/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

import java.text.NumberFormat;

/**
 * Concrete methods for outputting the receipt.
 * 
 * @author Liz Ife Van Deslunt
 */
public class ReceiptOutputStrategy {
    private NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
    private NumberFormat percentFormatter = NumberFormat.getPercentInstance();
    
    public static String registerReceiptToConsole(){
        
        return "";
    }
    
}
