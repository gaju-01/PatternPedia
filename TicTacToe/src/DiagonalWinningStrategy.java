public class DiagonalWinningStrategy extends WinningStrategy{
    @Override
    public int[] winningStrategy(Player player, Board board) {
        int boardSize = board.getSize(), index = -1;
        char[][] boardState = board.getBoard();
        int[] ans = {-1, -1};

        boolean ok = true;
        for(int i = 0; i < boardSize; i++) {
            ok = ok && (boardState[i][i] == '\u0000' || boardState[i][i] == player.getSymbol());
            if(boardState[i][i] == '\u0000') {
                index = i;
            }
        }

        if(ok) {
            ans[0] = index;
            ans[1] = index;
        }

        index = -1;
        for(int i = 0; i < boardSize; i++) {
            ok = ok && (boardState[i][boardSize - 1 - i] == '\u0000' || boardState[i][boardSize - 1 - i] == player.getSymbol());
            if(boardState[i][boardSize - 1 - i] == '\u0000') {
                index = i;
            }
        }

        if(ok) {
            ans[0] = index;
            ans[1] = index;
        }

        return ans;
    }
}
