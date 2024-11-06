import java.util.Scanner;

public class NQueensFirstQueenPlaced {

    static boolean solutionFound = false;

    // Check if placing a queen at board[row][col] is safe
    private static boolean isSafe(char[][] board, int row, int col, int n) {
        // Check this column on the upper side
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    // Backtracking method to solve n-Queens with the first queen placed
    private static boolean solveNQueens(char[][] board, int row, int n) {
        if (row == n) {
            solutionFound = true;
            printBoard(board);
            return true;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';  // Place queen
                if (solveNQueens(board, row + 1, n)) return true;  // Recur to place rest
                board[row][col] = '.';  // Backtrack
            }
        }
        return false;
    }

    // Method to print the board
    private static void printBoard(char[][] board) {
        System.out.println("Final N-Queens Board Configuration:");
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter the size of the board (n): ");
//        int n = scanner.nextInt();
//
//        // Initialize the board with '.'
//        char[][] board = new char[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                board[i][j] = '.';
//            }
//        }
//
//        // Get the initial position for the first queen from the user
//        System.out.print("Enter the row for the first queen (0-based index): ");
//        int firstRow = scanner.nextInt();
//        System.out.print("Enter the column for the first queen (0-based index): ");
//        int firstCol = scanner.nextInt();
//
//        // Place the first queen and start solving from the next row
//        board[firstRow][firstCol] = 'Q';
//        if (!solveNQueens(board, firstRow + 1, n) && !solutionFound) {
//            System.out.println("No solution exists with the first queen placed at (" + firstRow + ", " + firstCol + ").");
//        }
//
//
//
//
//
//        scanner.close();
//    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the board (N x N): ");
        int n = sc.nextInt();

        char[][] board = new char[n][n];

        // Initialize the board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }

        System.out.print("Enter the row for the initial queen: ");
        int firstRow = sc.nextInt();
        System.out.print("Enter the column for the initial queen: ");
        int firstCol = sc.nextInt();

        if (firstRow >= 0 && firstRow < n && firstCol >= 0 && firstCol < n) {
            board[firstRow][firstCol] = 'Q'; // Place the initial queen
            solveNQueens(board, firstRow + 1, n); // Start placing queens from the next row
            //System.out.println("Number of ways queens can be placed: " + count);
        } else {
            System.out.println("Invalid position for initial queen.");
        }

        sc.close();
    }
}

