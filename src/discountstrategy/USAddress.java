/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author Liz Ife Van Deslunt
 */
public class USAddress implements Address {
    private static final String ENTRY_ERR = "Please enter a value for "; //add the variable here
    private static final String ZIP_FORMAT_ERR = "Please enter a five-digit zip code."
            + "(Numbers only)";
    private static final String STATE_FORMAT_ERR = "Please enter a US state using "
            + "its two-letter abbreviation.";
    
    private String toAttn;
    private String lineOne;
    private String lineTwo;
    private String city;
    private String state; //two digit abbreviation
    private String zip;
    private final String country = "US"; //USAddress must be in the US!
    
    /**
     * Constructor that allows you to supply all fields.
     */
    public USAddress(String toAttn, String lineOne, String lineTwo, String city,
            String state, String zip){
        
        setToAttn(toAttn);
        setLineOne(lineOne);
        setLineTwo(lineTwo);
        setCity(city);
        setState(state);
        setZip(zip);
    }
    
    /**
     * Constructor that omits lineTwo of the address (and sets it to "").
     * @param toAttn 
     */
    public USAddress(String toAttn, String lineOne, String city,
            String state, String zip){
        
        setToAttn(toAttn);
        setLineOne(lineOne);
        lineTwo = "";
        setCity(city);
        setState(state);
        setZip(zip);
    }
    
    // setters
    
    @Override
    public final void setToAttn(String toAttn){
        if(toAttn == null){
            throw new NullPointerException(ENTRY_ERR + "toAttn");
        } else if(toAttn.length() == 0){
            throw new IllegalArgumentException(ENTRY_ERR + toAttn);
        }
        this.toAttn = toAttn;
        
    }
    @Override
    public final void setLineOne(String lineOne){
         if(lineOne == null){
            throw new NullPointerException(ENTRY_ERR + "lineOne");
        } else if(lineOne.length() == 0){
            throw new IllegalArgumentException(ENTRY_ERR + lineOne);
        }
        this.lineOne = lineOne;
    }
    @Override
    public final void setLineTwo(String lineTwo){
         if(lineTwo == null){
            throw new NullPointerException(ENTRY_ERR + "lineTwo");
        } else if(lineTwo.length() == 0){
            throw new IllegalArgumentException(ENTRY_ERR + lineTwo);
        }
        this.lineTwo = lineTwo;
    }
    @Override
    public final void setCity(String city){
         if(city == null){
            throw new NullPointerException(ENTRY_ERR + "city");
        } else if(city.length() == 0){
            throw new IllegalArgumentException(ENTRY_ERR + city);
        }
        this.city = city;
    }
    public final void setState(String state){
        if(state == null){
            throw new NullPointerException(ENTRY_ERR + "state");
        } else if(!(validateState(state))){
            throw new IllegalArgumentException(STATE_FORMAT_ERR);
        }
        this.state = state;
    }
    public final void setZip(String zip){
         if(zip == null){
            throw new NullPointerException(ENTRY_ERR + "zip");
         } else if(!(validateZipContents(zip))){
            throw new IllegalArgumentException(ZIP_FORMAT_ERR + "(you entered: " + zip + ")");
         } 
         
        this.zip = zip;
    }
    
    // getters
    
    @Override
    public final String getToAttn(){
        return toAttn;
    }
    @Override
    public final String getLineOne(){
        return lineOne;
    }
    @Override
    public final String getLineTwo(){
        return lineTwo;
    }
    @Override
    public final String getCity(){
        return city;
    }
    public final String getState(){
        return state;
    }
    public final String getZip(){
        return zip;
    }
    
    @Override
    public final String getCountry(){
        return country;
    }
    
    @Override
    public final String getFormattedAddress(){
        if(lineTwo.equals("")){
            return toAttn + "\n"
                + lineOne + "\n"
                + city + ", " + state + " " + zip + "\n"
                + country;
        }
        return toAttn + "\n"
                + lineOne + "\n"
                + lineTwo +"\n"
                + city + ", " + state + " " + zip + "\n"
                + country;
                        
    }
 
    /**
     * Returns true iff each character in the zip String is a digit, otherwise
     * returns false.
     */
    private boolean validateZipContents(String zip){
        if(zip == null){
            return false;
        }
        char[] characters = zip.toCharArray();
         for(int i = 0; i < characters.length; i++){
             //if any character is NOT a digit...
             if(   !(    characters[i] == '1' || characters[i] == '2'
                     || characters[i] == '3' || characters[i] == '4'
                     || characters[i] == '5' || characters[i] == '6'
                     || characters[i] == '7' || characters[i] == '8'
                     || characters[i] == '9' || characters[i] == '0')){
                 
                 return false;
             }
         }
         
         return true;
    }
    
    /**
     * Returns true iff state is a valid, two-character US State
     * @param state
     * @return 
     */
    private boolean validateState(String state){
        //if you find the state, return true
        for(int i = 0; i < US_StateList.US_STATE_LIST.length; i++){
            if(state.equals(US_StateList.US_STATE_LIST[i])){
                return true;
            }
        }
        //if you exit the loop, you haven't found the state and it's not valid.
        return false;
    }
}
