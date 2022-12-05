import java.util.Scanner;

/**
 * APlayer subclass that represents the HumanPlayer
 */
public class HumanPlayer extends APlayer
{

    // constructors
    /**
     * Creates the HumanPlayer object
     * 
     * @param game represents the game that the humanPlayer is in
     * @param symbol represents the humanPlayer's symbol (X)
     */
    HumanPlayer(Game game, char symbol){
        this.game = game;
        this.symbol = 'X';
    }

    // methods
    /**
     * Method that allows input from the user for the humanPlayer
     * Only allows two characters that are both valid
     * 
     * @return null, if the user inputted quit
     * @return move, if the move is valid 
     */
    public Move pickMove(){

        Scanner scany = new Scanner(System.in);

        // takes input from user
        System.out.println("What move do you want to make (any combination of valid letter + number, ex. B3, or quit)?");
        String uMove = scany.next();

        String uMove2 = uMove.toUpperCase();

        // case 1, if player wants to quit
        if (uMove2.compareTo("QUIT") == 0){
            return null;
        }

        else{

            while (uMove.length() != 2){
                System.out.println("Please enter only 2 characters (ex. B3, A4).");
                uMove = scany.next();
                uMove2 = uMove.toUpperCase();

                if (uMove2.compareTo("QUIT") == 0){
                    return null;
                }
            }

            // checks to see if move is a valid combination{
            while((int)(uMove2.charAt(0)) < 65 || (int)(uMove2.charAt(0)) > game.boardSize + 64 || uMove2.charAt(1) < 48 || uMove2.charAt(1) > game.boardSize + 48){
                System.out.println("Please enter a valid input on the board (ex. B3, A4).");
                uMove = scany.next();
                uMove2 = uMove.toUpperCase();

                if (uMove2.compareTo("QUIT") == 0){
                    return null;
                }
            }

            // if it is a valid combination, check to see if slot is empty
            int gameRow = (int)(uMove2.charAt(0)) - 65;
            int gameCol = uMove2.charAt(1) - 49;

            while (game.board[gameRow][gameCol] != game.blankSymbol){
                System.out.println("Slot is taken already. Pick a different slot.");
                uMove = scany.next();
                uMove2 = uMove.toUpperCase();
                gameRow = (int)(uMove2.charAt(0)) - 65;
                gameCol = uMove2.charAt(1) - 49;

                if (uMove2.compareTo("QUIT") == 0){
                    return null;
                }
            }

            // if it is a valid combination and the slot is empty
            Move move = new Move(gameRow, gameCol);
            return move;
        }
    }
}
