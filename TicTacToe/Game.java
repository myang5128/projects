import java.util.Scanner;
import java.lang.Object;
import java.lang.Math;

/**
 * Class representing the game state and workflow. Contains the main method and the board creator.
 * 
 */
public class Game extends Object
{

    // data fields
    /**
     * Represents the board as a matrix
     */
    char[][] board;

    /**
     * Represents the board size
     */
    int boardSize;

    /**
     * Represents the players, human and cpu
     */
    APlayer[] players;

    /**
     * Represents an empty slot in the matrix
     */
    char blankSymbol = ' ';

    /** 
     * Represents the cpu's symbol in the matrix
     */
    char cpuSymbol = 'O';

    /**
     * Represents the human's symbol in the matrix
     */
    char humanSymbol = 'X';

    // finish javaDoc

    // constructor that creates the game board
    /**
     * Creates a new Game object.
     * 
     * @param boardSize the size of the board
     */
    public Game(int boardSize){

        this.boardSize = boardSize;
        board = new char[boardSize][boardSize];

        // sets starting values
        for(int i = 0; i < boardSize; i++){
            for (int j = 0; j < boardSize; j++){
                board[i][j] = blankSymbol;
            }
        }
    }

    // helper methods for toString
    /**
     * Creates the horizontal lines in the matrix
     * 
     * @return a horizontal line made of - and |
     */
    public String lineString(){
        String bString2 = "";

        // loop
        for(int k = 0; k < boardSize; k++){
            if (k == boardSize - 1){
                bString2 += "---";
            }
            else{
                bString2 += "---|";
            }
        }
        return bString2;
    }

    // toString method that prints out the game properly
    /**
     * Creates the matrix 
     * 
     * @return a string representation of the board
     */
    public String toString(){

        String bString3 = "";

        // loop for column numbers
        int k = 0;

        while(k < boardSize){
            bString3 += "   " + (k + 1);
            k += 1;
        }

        // sets up space for everything else
        bString3 += "\n";

        // loop for everything else
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){

                // helper variable
                char cChar = (char)(i + 65);

                // if boardSize = 1
                if (boardSize == 1){
                    bString3 += cChar + "  " + board[i][j];
                }
                else{

                    // first element in the every row, 2 spaces in empty
                    if (j == 0){
                        bString3 += cChar + "  " + board[i][j] + " | ";
                    }

                    // last element in every row, but last
                    else if ((j == boardSize - 1) && (i < boardSize - 1)){
                        bString3 += board[i][j] + "\n  " + lineString() + "\n";
                    }

                    // last element in last row
                    else if ((j == boardSize - 1) && (i == boardSize - 1)){
                        bString3 += board[i][j];
                    }

                    // every element in between first and last in a row
                    else if ((j > 0) && (j < boardSize - 1)){
                        bString3 += board[i][j] + " | ";
                    }
                }

            }
        }
        return bString3;
    }

    // returns the game board size
    /**
     * Finds the board size
     * 
     * @return the size of the board
     */
    int getBoardSize(){
        return boardSize;
    }

    // resets the game
    /**
     * Resets the board by setting all the slots to the blank symbol
     */
    protected void resetGame(){
        // resets the board to blankSymbols
        for(int i = 0; i < boardSize; i++){
            for (int j = 0; j < boardSize; j++){
                board[i][j] = blankSymbol;
            }
        }
    }

    // executes the move
    /**
     * Executes a chosen move by changing the slot in the board to whichever player's turn it is
     * 
     * @param move The move chosen from the HumanPlayer class or the CpuPlayer class
     * @param symbol The symbol from whoever's turn it is
     */
    protected void executeMove(Move move, char symbol){

        board[move.row][move.col] = symbol;

    }

    // shows the game status
    /**
     * Shows the current game status and winning/losing conditions
     * ? if the game is still going on
     * X if the player has won
     * O if the computer has won
     * 
     * @return a character depicting the game status
     */
    public char getGameStatus(){

        char gameSymbol = '?';
        int bsize = boardSize - 1;
        char check1;

        // case one, when a row is filled
        for (int i = 0; i < boardSize; i++){
            int count = 0;

            if (board[i][0] != blankSymbol){
                check1 = board[i][0];

                for (int j = 0; j < boardSize; j++){

                    // if the next element of the row is the same as the initial, we increment count by 1
                    if (board[i][j] == check1){
                        count++;
                    }

                    // if count is equal to the boardSize, that means the row is filled with the same symbol
                    if (count == boardSize){
                        gameSymbol = check1;
                    }
                }
            }
        }

        // case two, when a column is filled
        for (int i = 0; i < boardSize; i++){
            int count = 0;

            if (board[0][i] != blankSymbol){
                check1 = board[0][i];

                for (int j = 0; j < boardSize; j++){

                    if (board[j][i] == check1){
                        count++;
                    }

                    if (count == boardSize){
                        gameSymbol = check1;
                    }
                }
            }
        }

        // case three, when a tl-br column is filled
        for (int i = 0; i < boardSize; i++){
            int count = 0;

            if (board[0][0] != blankSymbol){
                check1 = board[0][0];

                for (int j = 0; j < boardSize; j++){

                    if (board[j][j] == check1){
                        count++;
                    }

                    if (count == boardSize){
                        gameSymbol = check1;
                    }
                }
            }
        }

        // case four, when a tr-bl column is filled
        for (int i = 0; i < boardSize; i++){
            int count = 0;

            if (board[0][bsize] != blankSymbol){
                check1 = board[0][bsize];

                for (int j = 0; j < boardSize; j++){

                    if (board[j][bsize - j] == check1){
                        count++;
                    }

                    if (count == boardSize){
                        gameSymbol = check1;
                    }
                }
            }
        }

        return gameSymbol;
    }

    /**
     * A secondary method that shows the current game status and checks for tie
     * ? if the game is still going on
     * T if there is a tie
     * 
     * @return a character depicting the game status
     */
    public char gameStatusTie(){
        char gameSymbol2 = 'T';

        // case five, when the board is filled
        for (int i = 0; i < boardSize; i++){

            for (int j = 0; j < boardSize; j++){

                if (board[i][j] == blankSymbol){
                    gameSymbol2 = '?';
                }
            }

        }

        return gameSymbol2;
    }

    /**
     * A simple number generation in the range of [1,5]
     * 
     * @return the random number generated
     */
    public int NumGen(){
        return (int)(5 * Math.random()) + 1;
    }

    /**
     * Method that implements a single game of TicTacToe that includes the loop for going through turns and checking game statuses
     * 
     * @param moveTurn a random number generated in the main method that indicates who goes first in the game
     */
    public void playSingleGame(int moveTurn){

        // creates objects
        HumanPlayer humanPlayer = new HumanPlayer(this, humanSymbol);
        CpuPlayer cpuPlayer = new CpuPlayer(this, cpuSymbol);

        while (getGameStatus() == '?' || gameStatusTie() == '?'){
            // human, then cpu
            if (moveTurn > 5){

                // human
                Move MOVE = humanPlayer.pickMove();
                if (MOVE == null){
                    System.out.println("Game over.");
                    System.exit(0);
                }
                else{
                    executeMove(MOVE, humanSymbol);
                }

                // this prints out the board
                System.out.println(this);

                // if boardStatus changes, stop the loop
                if (getGameStatus() != '?' || gameStatusTie() != '?'){
                    break;
                }

                // cpu
                executeMove(cpuPlayer.pickMove(), cpuSymbol);
                // this prints out the board
                System.out.println(this);
                // if boardStatus changes, stop the loop
                if (getGameStatus() != '?' || gameStatusTie() != '?'){
                    break;
                }
            }

            // cpu, then human
            else{

                //cpu
                executeMove(cpuPlayer.pickMove(), cpuSymbol);

                // this prints out the board
                System.out.println(this);

                // if boardStatus changes, stop the loop
                if (getGameStatus() != '?' || gameStatusTie() != '?'){
                    break;
                }

                // human
                Move MOVE = humanPlayer.pickMove();
                if (MOVE == null){
                    System.out.println("Game over.");
                    System.exit(0);
                }
                else{
                    executeMove(MOVE, humanSymbol);
                }

                // this prints out the board
                System.out.println(this);

                // if boardStatus changes, stop the loop
                if (getGameStatus() != '?' || gameStatusTie() != '?'){
                    break;
                }
            }
        }

        // status checker for end
        if (getGameStatus() != '?' || gameStatusTie() != '?'){

            // for player wins
            if (getGameStatus() == 'X'){
                int Message = NumGen();
                if (Message == 1){
                    System.out.println("Wow, you're so good. You beat a defenseless bot.");
                }
                else if (Message == 2){
                    System.out.println("Yippie, you won against a bot!!!!");
                }
                else if (Message == 3){
                    System.out.println("*fanfare plays* The winner! Is YOU!");
                }
                else if (Message == 4){
                    System.out.println("So cool, so amazing, so beautiful, so human.");
                }
                else{
                    System.out.println("You have raged against the machine.");
                }
            }

            // for computer wins
            else if (getGameStatus() == 'O'){
                int Message = NumGen();
                if (Message == 1){
                    System.out.println("How did you lose...against a bot???");
                }
                else if (Message == 2){
                    System.out.println("I'm not mad, just disappointed in you.");
                }
                else if (Message == 3){
                    System.out.println("At least tell me you were messing around, please??");
                }
                else if (Message == 4){
                    System.out.println("Pathetic attempt.");
                }
                else{
                    System.out.println("Dwight didn't lose, but you did.");
                }
            }

            // for ties
            else if (gameStatusTie() == 'T'){
                int Message = NumGen();
                if (Message == 1){
                    System.out.println("At least, it was a tie, I guess?");
                }
                else if (Message == 2){
                    System.out.println("Seriously?");
                }
                else if (Message == 3){
                    System.out.println("Try harder next time.");
                }
                else if (Message == 4){
                    System.out.println("Here's a tip: win.");
                }
                else{
                    System.out.println("The only ties that are acceptable are physical.");
                }
            }
        }
    }

    // main method
    /**
     * The main method that incorporates the stats, running a single game, and checking to see if the player wants to continue playing afterwards
     * 
     * @param args Uses a try-catch method to make sure the args is within [1,9], if not, it would set the value to 3
     */
    public static void main(String[] args){

        System.out.println("Tic Tac Toe Game \n Begins now! \n");
        int gameLoop = 1;
        GameStats gameStats = new GameStats();
        Scanner scany = new Scanner(System.in);

        while (gameLoop == 1 || gameLoop == 2){
            try{

                // initial inputs
                int boardSize = Integer.parseInt(args[0]);
                int moveTurn = (int)(10 * Math.random());

                // if index is in bounds, check size validity
                if(boardSize > 0 && boardSize < 10){

                    System.out.println("Setting board size to " + boardSize);
                    Game gameBoard = new Game(boardSize);
                    System.out.println(gameBoard);

                    gameBoard.playSingleGame(moveTurn);

                    // update and print stats
                    if (gameBoard.getGameStatus() == 'X'){
                        gameStats.nwins++;
                    }
                    else if (gameBoard.getGameStatus() == 'O'){
                        gameStats.nlosses++;
                    }
                    else if (gameBoard.gameStatusTie() == 'T'){
                        gameStats.nties++;
                    }
                }

                else{
                    System.out.println("Setting board size to 3.");

                    Game gameBoard = new Game(3);
                    System.out.println(gameBoard);

                    gameBoard.playSingleGame(moveTurn);

                    if (gameBoard.getGameStatus() == 'X'){
                        gameStats.nwins++;
                    }
                    else if (gameBoard.getGameStatus() == 'O'){
                        gameStats.nlosses++;
                    }
                    else if (gameBoard.gameStatusTie() == 'T'){
                        gameStats.nties++;
                    }
                }

                // this stops the loop
                gameLoop = 0;
                System.out.println(gameStats);
                Game gameBoard = new Game(boardSize);

                // asks if player wants to start a new game
                System.out.println("Do you want to play another game? (Y or N) \n");
                String gameContinue2 = scany.next();
                String gameContinue = gameContinue2.toUpperCase();

                // checks player input
                while(gameContinue.compareTo("Y") != 0 && gameContinue.compareTo("N") != 0){
                    System.out.println("Enter a valid input (Y or N)");
                    gameContinue2 = scany.next();
                    gameContinue = gameContinue2.toUpperCase();
                }
                if (gameContinue.compareTo("Y") == 0){
                    System.out.println("Starting new game. \n");
                    gameBoard.resetGame();
                    gameLoop = 1;
                }
                else if (gameContinue.compareTo("N") == 0){
                    System.out.println("Ending game. \n");
                    System.exit(0);
                }

            }

            // if index is out of bounds, set default size to 3
            catch(Exception e){

                int boardSize = 3;
                int moveTurn = (int)(10 * Math.random());

                System.out.println("Invalid board size. Defaulting board size to 3.");

                Game gameBoard = new Game(3);
                System.out.println(gameBoard);

                gameBoard.playSingleGame(moveTurn);

                if (gameBoard.getGameStatus() == 'X'){
                    gameStats.nwins++;
                }
                else if (gameBoard.getGameStatus() == 'O'){
                    gameStats.nlosses++;
                }
                else if (gameBoard.gameStatusTie() == 'T'){
                    gameStats.nties++;
                }

                // this stops the loop
                gameLoop = 0;
                System.out.println(gameStats);

                // asks if player wants to start a new game
                System.out.println("Do you want to play another game? (Y or N) \n");
                String gameContinue2 = scany.next();
                String gameContinue = gameContinue2.toUpperCase();

                // checks player input
                while(gameContinue.compareTo("Y") != 0 && gameContinue.compareTo("N") != 0){
                    System.out.println("Enter a valid input (Y or N)");
                    gameContinue2 = scany.next();
                    gameContinue = gameContinue2.toUpperCase();
                }

                if (gameContinue.compareTo("Y") == 0){
                    System.out.println("Starting new game. \n");
                    gameBoard.resetGame();
                    gameLoop = 1;
                }

                else if (gameContinue.compareTo("N") == 0){
                    System.out.println("Ending game. \n");
                    System.exit(0);
                }

            }
        }

    }
}
