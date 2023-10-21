package tareagato.tictactoe;

import java.util.Scanner;

/**
 *
 * @author migue
 */
public class TareaGatoTictactoe {

    public static void main(String[] args) {
        //       /\_/\  
        //      ( o.o ) 
        //       > ^ <
        // Lo siento tenia que hacerlo 
        System.out.println("Meow, soy un lindo gatito!");
        System.out.println("   /\\_/\\"); 
        System.out.println("  ( o.o )");
        System.out.println("   > ^ <");
        System.out.println("Bienvenido al juego!");
        /**
         * Estos son los metodos que se utilizaran para los jugadores
         * @param playerOneSymbol el simbolo del jugador uno sera la X
         * @param playerTwoSymbol el simbolo del jugador dos sera la O
         */
        char playerOneSymbol = 'X';
        char playerTwoSymbol = 'O';

        Board board = new Board(playerOneSymbol, playerTwoSymbol);
        boolean gameOver = false; // Mientras sea flase el juego sigue
        int currentPlayer = 1;

        while (!gameOver) {
            char currentSymbol = (currentPlayer == 1)
                    ? playerOneSymbol : playerTwoSymbol;

            // Imprimir el tablero actual
            char[][] currentBoard = board.getBoard();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(currentBoard[i][j] + " ");
                }
                System.out.println();
            }
            // El metodo por el cual se leeran las entradas de la matriz
            Scanner scanner = new Scanner(System.in);
            System.out.print("Jugador " + currentPlayer + ", ingresa la fila y "
                    + "columna (ejemplo: 1 2): ");
            /**
             * Estas seran las lecturas de las filas y columnas del juego
             * @param row se referira a las filas 
             * @param col se referira a las columnas
             */
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            /**
             * Metodo por el cual se detecta cual fue el ganar atraves de la 
             * lectura de las celdas
             */
            if (currentBoard[row][col] == ' ') {
                // Lectura y llamado de las celdas del board
                board.setCell(row, col, currentSymbol);
                // Revision de las celdas para detectar al ganador
                if (checkWin(currentBoard, currentSymbol)) {
                System.out.println("¡Jugador " + currentPlayer + " ha ganado!");
                    // Supuesto intento de guardar los puntos del ganador
                    // Spoiler (Salio mal :c)
                    if (currentPlayer == 1) {
                        board.playerOneWins();
                    } else {
                        board.playerTwoWins();
                    }
                    // Metodo por el cual se finaliza el bucle del juego
                    gameOver = true;
                } else if (isBoardFull(currentBoard)) {
                    System.out.println("¡Empate!"); // Caso de empate
                    gameOver = true;
                } else {
                    currentPlayer = (currentPlayer == 1) ? 2 : 1;
                }
            } else {
              // En caso de que la celda ya tenga un valor dentro de ella
              System.out.println("La celda ya está ocupada. Intenta de nuevo.");
            }
        }
    }

    // Método para verificar si el tablero está lleno (empate)
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
     * Método para verificar si un jugador ha ganado
     * verificara si cualquier columna, fila o diagonal tienen simbolos 
     * similares, de ser asi habra un ganador
     */
    public static boolean checkWin(char[][] board, char symbol) {
        // Verificar filas
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] 
                    == symbol) {
                return true;
            }
        }

        // Verificar columnas
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == symbol && board[1][j] == symbol && board[2][j] 
                    == symbol) {
                return true;
            }
        }

        // Verificar diagonales
        if ((board[0][0] == symbol && board[1][1] == symbol && board[2][2] 
                == symbol)
                || (board[0][2] == symbol && board[1][1] 
                == symbol && board[2][0] == symbol)) {
            return true;
        }
        return false;
    }
    
}
