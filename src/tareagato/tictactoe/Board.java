package tareagato.tictactoe;

public class Board {

    private char[][] board;

    private char playerOne;

    private char playerTwo;

    private int playerOneWins;

    private int playerTwoWins;

    public Board(char playerOne, char playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.board = new char[3][3]; // Matriz 3x3 para el juego de Gato
        initializeBoard();
        playerOneWins = 0;
        playerTwoWins = 0;
    }

    // Inicializar el tablero
    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
              board[i][j] = ' '; // Espacios en blanco representan celdas vacías
            }
        }
    }

    // Métodos para obtener y actualizar el tablero
    public char[][] getBoard() {
        return board;
    }

    public void setCell(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // Métodos para comprobar el estado del juego y gestionar las victorias
    public boolean checkWin(char symbol) {

        return false; // Por ahora, se retorna falso.
    }

    // De los errores se aprende, intento de conteo de victorias fallido
    public void playerOneWins() {
        playerOneWins++;
    }

    public void playerTwoWins() {
        playerTwoWins++;
    }
}
