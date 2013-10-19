/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 * A basic template for an address. It does not include country-specific fields,
 * such as state, province, or zip.
 * 
 * @author Liz Ife Van Deslunt
 */
public interface AddressStrategy {
    
    public void setToAttn(String toAttn) throws IllegalArgumentException, NullPointerException;
    public void setLineOne(String lineOne) throws IllegalArgumentException, NullPointerException;
    public void setLineTwo(String lineTwo) throws IllegalArgumentException, NullPointerException;
    public void setCity(String city) throws IllegalArgumentException, NullPointerException;
    
    public String getToAttn();
    public String getLineOne();
    public String getLineTwo();
    public String getCity();
    public String getCountry();
    
    /**
     * Returns the address in a readable format for printing.
     * @return 
     */
    public String getFormattedAddress();
    
}
