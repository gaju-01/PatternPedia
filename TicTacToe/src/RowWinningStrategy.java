public class RowWinningStrategy extends WinningStrategy{
    @Override
    public int[] winningStrategy(Player player, Board board) {
        int boardSize = board.getSize();
        char[][] boardState = board.getBoard();;
        int[] ans = {-1, -1};

        for(int i = 0; i < boardSize; i++) {
            boolean ok = true;
            int index = -1;
            for(int j = 0; j < boardSize; j++) {
                ok = ok && (boardState[i][j] == '\u0000' || boardState[i][j] == player.getSymbol());
                if(boardState[i][j] == '\u0000') {
                    index = j;
                }
            }
            if(ok) {
                ans[0] = i;
                ans[1]= index;
                break;
            }
        }
        return ans;
    }
}
