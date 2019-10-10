package tictactoe;

import java.util.Scanner;

public class TicTacToe {

    private Scanner scanner;
    private Board board;

    public TicTacToe(Scanner scanner) {
        this.scanner = scanner;
        this.board = new Board();
    }

    public void run() {
        String placing = getStartingPlacing();

        Board board = new Board(placing);
        System.out.print(board);

        States state = BoardStateChecker.complexCheck(board);
        printBoardState(board, state);
    }

    private String getStartingPlacing() {
        System.out.print("Enter cells: ");
        String state = scanner.nextLine();

        return state;

    }

    private void printBoardState(Board board,States state) {
        String message = "";

        switch(state) {
            case DRAW: message = "Draw"; break;
            case PLAYER1_WINS: message = board.getPlayer1Sign() + " wins"; break;
            case PLAYER2_WINS: message = board.getPlayer2Sign() + " wins"; break;
            case IMPOSSIBLE: message = "Impossible"; break;
            case NOT_FINISHED: message = "Game not finished"; break;
        }

        System.out.println(message);
    }

}
