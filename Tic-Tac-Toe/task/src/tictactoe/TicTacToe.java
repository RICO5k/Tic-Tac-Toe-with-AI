package tictactoe;

import java.util.Scanner;

public class TicTacToe {

    private Scanner scanner;
    private Board board;
    private States state;
    private char turn;

    public TicTacToe(Scanner scanner) {
        this.scanner = scanner;
        this.turn = 'X';
    }

    public void run() {
        String placing = getStartingPlacing();

        this.board = new Board(placing);
        System.out.print(board);

        makeMove();

        System.out.println(board);
    }

    private void changePlayerTurn() {
        if(this.turn == 'X') {
            this.turn = 'O';
        } else {
            this.turn = 'X';
        }
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
            case NOT_FINISHED: message = "Player " + turn + " turn"; break;
        }

        System.out.println(message);
    }

    private Coordinates getCorrectCoordinates() {
        int x, y;

        do {
            System.out.print("Enter the coordinates: ");
            y = Integer.parseInt(scanner.next())-1;
            x = 2-(Integer.parseInt(scanner.next())-1);
        } while(!board.isCorrect(x, y));

        return new Coordinates(x, y);
    }

    private void makeMove() {
        Coordinates coordinates = getCorrectCoordinates();
        board.makeMove(coordinates, turn);
    }
}
