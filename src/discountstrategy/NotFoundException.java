
package discountstrategy;

/**
 * A custom exception that is thrown when an item is not found in the database.
 * @author Liz Ife Van Deslunt
 */
public class NotFoundException extends IllegalArgumentException {
    
    public NotFoundException(){
        super("That item was not found in the database.");
    }
    
    public NotFoundException(String msg){
        super(msg);
    }
}
