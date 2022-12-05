

/**
 * The parent class of players
 */
public class APlayer
{
    
    // fields
    /**
     * Represents the game that the players are in
     */
    protected Game game;
    
    /**
     * Represents the symbol of the players
     */
    protected char symbol;
    
    // constructors
    /**
     * Empty default constructor
     */
    protected APlayer(){
    }
    
    /**
     * Default APLAYER constructor that contains the game that the players are in and the symbol of the players
     * 
     * @param game the game that the players are in
     * @param symbol the symbol of the players
     */
    protected APlayer(Game game, char symbol){
        this.game = game;
        this.symbol = symbol;
    }
    
    // methods
    /**
     * Returns the symbol of the players
     * 
     * @return the symbol of the players
     */
    public char getSymbol(){
        return symbol;
    }
    
    /**
     * default method of finding the moves
     * 
     * @return null
     */
    public Move pickMove(){
        return null;
    }
    
}
