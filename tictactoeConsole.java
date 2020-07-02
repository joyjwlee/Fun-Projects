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

            printBoard();
            turn = 1 - turn;
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
}