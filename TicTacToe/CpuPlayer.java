import java.lang.Math;

/**
 * APlayer subclass that represents the CPU
 */
public class CpuPlayer extends APlayer
{

    // constructor
    /**
     * Creates the CpuPlayer object 
     * 
     * @param game represents the game that the cpuPlayer is in
     * @param symbol represents the cpuPlayer's symbol (O)
     */
    public CpuPlayer(Game game, char symbol){
        this.game = game;
        this.symbol = 'O';

    }

    // methods
    /**
     * Method that randomly picks a valid spot for the CPU
     * 
     * @return the move that is picked
     */
    public Move pickMove(){

        // creates initial move
        int gameRow = (int)(game.boardSize * Math.random());
        int gameCol = (int)(game.boardSize * Math.random());

        // checks to see if board slot is filled
        while(game.board[gameRow][gameCol] != game.blankSymbol){
            gameRow = (int)(game.boardSize * Math.random());
            gameCol = (int)(game.boardSize * Math.random());
        }

        if (game.board[gameRow][gameCol] == game.blankSymbol){
            Move move = new Move(gameRow, gameCol);
            return move;
        }
        else{
            while(true){
                gameRow = (int)(game.boardSize * Math.random());
                gameCol = (int)(game.boardSize * Math.random());
            }
        }

    }

}
