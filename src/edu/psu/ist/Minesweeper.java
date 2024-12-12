package edu.psu.ist;

public class Minesweeper {
    private char[][] board;
    public static final int SIZE = 4;

    public Minesweeper() {
        board = new char[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                board[row][col] = '-';
            }
        }

        board[0][2] = '*';
        board[1][2] = '*';
    }

    public void setBoard(char[][] newBoard) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                board[row][col] = newBoard[row][col];
            }
        }
    }

    public String renderBoard() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                sb.append(board[row][col]);
                if (col < SIZE - 1) {
                    sb.append(' ');
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public int updateBoard(int row, int col) {
        if (board[row][col] == '*') {
            return -1; // This is if the player hit a mine
        } else {
            int mineCount = countAdjacentMines(row, col);
            board[row][col] = Character.forDigit(mineCount, 10); // Displays the mine count
            return checkWin() ? 1 : 0; // updateBoard returns 1 for a win and returns 0 for ongoing game
        }
    }

    private int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (r >= 0 && r < SIZE && c >= 0 && c < SIZE) { // Check bounds
                    if (board[r][c] == '*') {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean checkWin() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == '-' && !isMine(row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isMine(int row, int col) {
        return board[row][col] == '*';
    }


    public char[][] getBoard() {
        return board;
    }

}

