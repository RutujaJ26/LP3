import java.util.Scanner;

public class NQueens {
    static int count = 0;

    // Method to print the board
    static void pBoard(char[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
    }

    // Method to check if a queen can be safely placed
    static boolean isSafe(char[][] board, int row, int col, int n) {
        // Check vertically above
//        for (int i = row - 1; i >= 0; i--) {
        for (int i = 0; i < row; i++) {

        if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // Recursive method to place queens
    static void qPlace(char[][] board, int row, int n) {
        if (row == n) {
            count++;
            pBoard(board, n);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j, n)) {
                board[row][j] = 'Q';
                qPlace(board, row + 1, n);
                board[row][j] = 'X';  // Backtrack
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input for the board size
        System.out.print("Enter the size of the board (N x N): ");
        int n = sc.nextInt();

        char[][] board = new char[n][n];

        // Initialize the board with 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }

        // Take user input for the initial queen's position
        System.out.print("Enter the row position for the initial queen (0 to " + (n - 1) + "): ");
        int initialRow = sc.nextInt();
        System.out.print("Enter the column position for the initial queen (0 to " + (n - 1) + "): ");
        int initialCol = sc.nextInt();

        // Place the initial queen at the specified position if it's within bounds
        if (initialRow >= 0 && initialRow < n && initialCol >= 0 && initialCol < n) {
            board[initialRow][initialCol] = 'Q';
            // Start placing queens from the next row
            qPlace(board, initialRow + 1, n);

            System.out.println("Number of ways queens can be placed: " + count);
        } else {
            System.out.println("Invalid position for the initial queen.");
        }

        sc.close();
    }
}


//import java.util.Scanner;
//
//public class NQueens {
//
//    // Method to check if a queen can be placed at board[row][col]
//    private static boolean isSafe(char[][] board, int row, int col, int n) {
//        // Check this column on upper side
//        for (int i = 0; i < row; i++) {
//            if (board[i][col] == 'Q') {
//                return false;
//            }
//        }
//
//        // Check upper diagonal on left side
//        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
//            if (board[i][j] == 'Q') {
//                return false;
//            }
//        }
//
//        // Check upper diagonal on right side
//        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
//            if (board[i][j] == 'Q') {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    // Method to solve n-Queens problem using backtracking
//    private static boolean solveNQueens(char[][] board, int row, int n) {
//        if (row == n) {
//            return true;  // All queens are placed
//        }
//
//        for (int col = 0; col < n; col++) {
//            if (isSafe(board, row, col, n)) {
//                board[row][col] = 'Q';  // Place queen
//                if (solveNQueens(board, row + 1, n)) {
//                    return true;  // Solution found
//                }
//                board[row][col] = '.';  // Backtrack
//            }
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter the value of n for an n x n board: ");
//        int n = scanner.nextInt();
//
//        // Initialize n x n board with '.'
//        char[][] board = new char[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                board[i][j] = '.';
//            }
//        }
//
//        // Place the first queen based on user input
//        System.out.print("Enter the row (0 to " + (n - 1) + ") of the first queen: ");
//        int firstRow = scanner.nextInt();
//        System.out.print("Enter the column (0 to " + (n - 1) + ") of the first queen: ");
//        int firstCol = scanner.nextInt();
//
//        // Place the first queen
//        board[firstRow][firstCol] = 'Q';
//
//        // Start solving the rest of the board from the next row
//        if (solveNQueens(board, firstRow + 1, n)) {
//            System.out.println("The final n-Queens board:");
//            printBoard(board);
//        } else {
//            System.out.println("No solution exists for this configuration.");
//        }
//
//        scanner.close();
//    }
//
//    // Method to print the board
//    private static void printBoard(char[][] board) {
//        for (char[] row : board) {
//            for (char cell : row) {
//                System.out.print(cell + " ");
//            }
//            System.out.println();
//        }
//    }
//}
