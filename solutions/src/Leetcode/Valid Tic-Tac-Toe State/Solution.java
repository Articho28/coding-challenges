class Solution {
    public boolean validTicTacToe(String[] board) {
        int zeros = 0;
        int ones = 0;
        int empty = 0;
        for (String row : board) {
            for (char c: row.toCharArray()) {
                if (c == 'X') { 
                    ones++;
                } else if (c == 'O') {
                    zeros++;
                } else {
                    empty++;
                }
            }
        }
        // There should never be more Os than Xs
        if (zeros > ones) {
            return false;
        
        } // There should never be more than one X over O at once. 
        else if (ones > zeros + 1) {
            return false;
        } else {
            // Check for victors
            // If X wins and there are equal Os to Xs, return false. 
            if (checkWinner('X', board) && ones == zeros) {
                return false;
            }
            // If O wins and there are unequal X to Os, return false.
            if (checkWinner('O', board) && ones != zeros) {
                return false;
            }
            return true;
        }
        
    }
    
    public static boolean checkWinner(char player, String[] board) {
        if (player != 'X' && player != 'O') {
            return false;
        }
        
        String winningString = player == 'X' ? "XXX" : "OOO";
        
                                

        //Check for rows 
        for (String row : board) {
            if (row.equals(winningString)) {
                return true;
            } 
        }
        
        //Check for columns
        for (int i = 0; i < 3; i++) {
            String sequence = "" + board[0].charAt(i) + board[1].charAt(i) + board[2].charAt(i);
            if (sequence.equals(winningString)) {
                return true;
            }
        }
        
        //Check for main diagonal
        String mainD = "" + board[0].charAt(0) + board[1].charAt(1) + board[2].charAt(2);
        if (mainD.equals(winningString)) {
            return true;
        }
        
        //Check offset diagnoal
        String offD = "" + board[0].charAt(2) + board[1].charAt(1) + board[2].charAt(0);
        if (offD.equals(winningString)) {
            return true;
        }
        
        return false;
    
    }
}