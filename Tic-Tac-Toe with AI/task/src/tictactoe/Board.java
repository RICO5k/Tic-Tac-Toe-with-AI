package tictactoe;

public class Board {

    private final char player1Sign = 'X';
    private final char player2Sign = 'O';

    private char[][] board;

    public Board() {
        board = new char[3][3];
    }

    public Board(String state) {
        this();
        int k = 1;

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                board[i][j] = state.charAt(k);
                k++;
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public char getPlayer1Sign() {
        return player1Sign;
    }

    public char getPlayer2Sign() {
        return player2Sign;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<5; i++) {
            for(int j=0; j<9; j++) {
                if(i==0 || i==4) {
                    sb.append('-');
                } else if(j==0 || j==8) {
                    sb.append('|');
                } else {
                    if(j%2 == 1)
                        sb.append(' ');
                    else
                        sb.append(board[i-1][j/2-1]);
                }
            }
            sb.append('\n');
        }

        return sb.toString();
    }
}
