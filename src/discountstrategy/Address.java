/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author Liz Ife Van Deslunt
 */
public interface Address {
    
    //does not have state or zip fields required because these vary by country
    
    public void setToAttn(String toAttn);
    public void setLineOne(String lineOne);
    public void setLineTwo(String lineTwo);
    public void setCity(String city);
    
    public String getToAttn();
    public String getLineOne();
    public String getLineTwo();
    public String getCity();
    public String getCountry();
    
    @Override
    public String toString();
    
}
