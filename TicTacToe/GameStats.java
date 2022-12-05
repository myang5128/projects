/**
 * Class representing the stats of TicTacToe
 */
public class GameStats
{
    
    // fields
    /**
     * Represents the number of losses the player has
     */
    int nlosses;
    
    /**
     * Represents the number of ties the player has
     */
    int nties;
    
    /**
     * Represents the number of wins the player has
     */
    int nwins;
    
    // constructor
    /**
     * Creates the GameStats object and sets the initial values of losses, ties, and wins to 0
     */
    public GameStats(){
        this.nlosses = 0;
        this.nties = 0;
        this.nwins = 0;
    }
    
    // methods
    /**
     * When called, increment wins by 1
     */
    public void recordWin(){
        nwins += 1;
    }
    
    /**
     * When called, increment ties by 1
     */
    public void recordTie(){
        nties += 1;
    }
    
    /**
     * When called, increment losses by 1
     */
    public void recordLoss(){
        nlosses += 1;
    }
    
    /**
     * A string representation of the player's stats
     * 
     * @return a string representation of the player's stats
     */
    public String toString(){
        return "Current stats: Wins(" + nwins + "), Losses(" + nlosses + "), Ties(" + nties + ").";
    }
    
}
