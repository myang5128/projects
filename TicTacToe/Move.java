
/**
 * Represents the Move class that contains the board's row and column placement
 */
public class Move
{
    
    // fields
    /**
     * Represents the column
     */
    int col;
    
    /**
     * Represents the row
     */
    int row;
    
    /**
     * Creates the Move object that sets the row and column to whatever they're called respectively
     * 
     * @param row the row argument
     * @param col the column argument
     */
    // constructor
    public Move(int row, int col){
        this.row = row;
        this.col = col;
    }
    
    // methods
    /**
     * Returns the row that is argued
     * 
     * @return the row that is argued
     */
    public int getRow(){
        return this.row;
    }
    
    /**
     * Returns the column that is argued
     * 
     * @return the column that is argued
     */
    public int getCol(){
        return this.col;
    }
}
