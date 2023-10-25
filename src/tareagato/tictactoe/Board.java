package tareagato.tictactoe;
/**
 * Board class
 * @author migue
 * @param board
 * @param playerOne
 * @param playerTwo
 * @param playerOneWins
 * @param playerTwoWins
 */
public class Board {

    public char[][] board;

    public char playerOne;

    public char playerTwo;

    public int playerOneWins;

    public int playerTwoWins;

    public Board(char playerOne, char playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.board = new char[3][3]; 
        initializeBoard();
        playerOneWins = 0;
        playerTwoWins = 0;
    }

    // Inicializar el tablero
    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
              board[i][j] = ' '; 
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public void setCell(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    public boolean checkWin(char symbol) {

        return false; 
    }

    public void playerOneWins() {
        playerOneWins++;
    }

    public void playerTwoWins() {
        playerTwoWins++;
    }
}
