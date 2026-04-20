class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // Find an empty cell
                if (board[row][col] == '.') {
                    // Try digits 1-9
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, row, col, c)) {
                            board[row][col] = c; // Place the digit

                            if (solve(board)) {
                                return true; // If it leads to a solution, stop
                            } else {
                                board[row][col] = '.'; // Backtrack (reset)
                            }
                        }
                    }
                    return false; // None of the digits 1-9 worked here
                }
            }
        }
        return true; // All cells filled correctly
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // Check row
            if (board[row][i] == c) return false;
            // Check column
            if (board[i][col] == c) return false;
            // Check 3x3 box
            // (row/3)*3 + i/3 gives the row index within the box
            // (col/3)*3 + i%3 gives the column index within the box
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
        }
        return true;
    }
}
