
public class Main{
    public static void main(String[] args) {
        String[] board = {"O  ", "   ", "   "};
        Solution solution = new Solution();
        boolean res = solution.validTicTacToe(board);
        System.out.println(res);
        String[] board2 = {"XOX", " X ", "   "};
        res = solution.validTicTacToe(board);
        System.out.println(res);
        String[] board3= {"XXX", "   ", "OOO"};
        res = solution.validTicTacToe(board3);
        System.out.println(res);
        String[] board4 = {"XOX", "O O", "XOX"};
        res = solution.validTicTacToe(board4);
        System.out.println(res);
    }
}