// simple tic tac toe game that runs in your console

import java.util.*;

public class tictactoeConsole {
    public static Scanner sc = new Scanner(System.in);
    public static String p1, p2;
    public static char[][] grid = new char[3][3];

    public static void main(String[] args) {
        intro();
        printBoard();
        playGame();
    }

    public static void intro() {
        // init board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = '.';
            }
        }
        // get info
        System.out.println("Player 1, please enter your name: ");
        p1 = sc.nextLine();
        System.out.println("Player 2, please enter your name: ");
        p2 = sc.nextLine();
        System.out.println("/=== Welcome to the match of the century, " + p1 + " and " + p2 + ". ===/");
    }

    public static void printBoard() {
        System.out.println("  1   2   3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == '.') {
                    System.out.print(" ");
                } else {
                    System.out.print(grid[i][j]);
                }
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            if (i < 2) {
                System.out.println("\n ---+---+---");
            }
        }
        System.out.println();
    }

    public static void playGame() {
        int r, c, turn = 1;
        boolean tied = false;
        while (winner() == '.') {
            if (turn == 1) {
                System.out.println(p1 + ", please enter a row and a column");
            } else {
                System.out.println(p2 + ", please enter a row and a column");
            }
            System.out.print("Row: ");
            r = sc.nextInt();
            System.out.print("Col: ");
            c = sc.nextInt();
            r--;
            c--;
            while (!isValid(r, c)) {
                System.out.println("That was not valid. Please enter again.");
                System.out.print("Row: ");
                r = sc.nextInt();
                System.out.print("Col: ");
                c = sc.nextInt();
                r--;
                c--;
            }
            if (turn == 1) {
                grid[r][c] = 'X';
            } else {
                grid[r][c] = 'O';
            }
            printBoard();
            if (isTied()) {
                System.out.println("The game is tied");
                tied = true;
                break;
            }
            turn = 1 - turn;
        }
        if (!tied) {
            turn = 1 - turn;
            if (turn == 1) {
                System.out.println(p1 + " wins! Congratulations!!");
            } else {
                System.out.println(p2 + " wins! Congratulations!!");
            }
        }
    }

    // X, O, or .
    public static char winner() {
        // vert and horiz
        for (int i = 0; i < 3; i++) {
            if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) {
                return grid[0][i];
            }
            if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
                return grid[i][0];
            }
        }

        // diagonals
        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            return grid[0][0];
        }
        if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
            return grid[0][2];
        }

        // otherwise no winner
        return '.';
    }

    public static boolean isValid(int r, int c) {
        if (0 <= r && r < 3) {
            if (0 <= c && c < 3) {
                if (grid[r][c] == '.') {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isTied() {
        if (winner() == '.') {
            int count = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (grid[i][j] != '.') {
                        count++;
                    }
                }
            }
            return count == 9;
        }
        return false;
    }
}