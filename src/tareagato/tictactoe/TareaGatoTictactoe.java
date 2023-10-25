package tareagato.tictactoe;

import java.util.Scanner;

/**
 *
 * @author migue
 */
public class TareaGatoTictactoe {

    public static void main(String[] args) {
       
        System.out.println("Meow, soy un lindo gatito!");
        System.out.println("   /\\_/\\");
        System.out.println("  ( o.o )");
        System.out.println("   > ^ <");
        System.out.println("Bienvenido al juego!");
        /**
         * this wanna be the method to use on the program
         *
         * @param playerOneSymbol symbol to player one X
         * @param playerTwoSymbol symbol to player two O
         */
        char playerOneSymbol = 'X';
        char playerTwoSymbol = 'O';

        Board board = new Board(playerOneSymbol, playerTwoSymbol);
        boolean gameOver = false;
        int currentPlayer = 1;

        while (!gameOver) {
            char currentSymbol = (currentPlayer == 1)
                    ? playerOneSymbol : playerTwoSymbol;

            char[][] currentBoard = board.getBoard();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(currentBoard[i][j] + " ");
                }
                System.out.println();
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Jugador " + currentPlayer + ", ingresa la fila y "
                    + "columna (ejemplo: 1 2): ");
            /**
             * Method to read columns and rows 
             *
             * @param row se referira a las filas
             * @param col se referira a las columnas
             */
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            /**
             * Method to read who wins and who lose
             * @param row 
             * @param col
             */
            if (currentBoard[row][col] == ' ') {

                board.setCell(row, col, currentSymbol);

                if (checkWin(currentBoard, currentSymbol)) {
                    System.out.println("¡Jugador " + currentPlayer + " ha ganado!");

                    if (currentPlayer == 1) {
                        board.playerOneWins();
                    } else {
                        board.playerTwoWins();
                    }
                    // Metodo por el cual se finaliza el bucle del juego
                    gameOver = true;
                } else if (isBoardFull(currentBoard)) {
                    System.out.println("¡Empate!");
                    gameOver = true;
                } else {
                    currentPlayer = (currentPlayer == 1) ? 2 : 1;
                }
            } else {

                System.out.println("La celda ya está ocupada. Intenta de nuevo.");
            }
        }
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Whit this can read who wins with the symbols and rows and columns
     * @param checkwin 
     * @param board
     * @param symbol
     */
    public static boolean checkWin(char[][] board, char symbol) {
        // Verificar filas
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2]
                    == symbol) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (board[0][j] == symbol && board[1][j] == symbol && board[2][j]
                    == symbol) {
                return true;
            }
        }

        if ((board[0][0] == symbol && board[1][1] == symbol && board[2][2]
                == symbol)
                || (board[0][2] == symbol && board[1][1]
                == symbol && board[2][0] == symbol)) {
            return true;
        }
        return false;
    }

}
