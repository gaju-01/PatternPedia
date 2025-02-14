public class ColumnWinningStrategy extends WinningStrategy{

    public static ColumnWinningStrategy columnWinningStrategy;
    private ColumnWinningStrategy() {}

    public static ColumnWinningStrategy getInstance() {
        if(columnWinningStrategy == null) {
            synchronized (ColumnWinningStrategy.class) {
                if(columnWinningStrategy == null)
                    columnWinningStrategy = new ColumnWinningStrategy();
            }
        }
        return columnWinningStrategy;
    }

    @Override
    public int[] winningStrategy(Player player, Board board) {
        int boardSize = board.getSize();
        int[] ans = {-1, -1};

        for(int i = 0; i < boardSize; i++) {
            boolean ok = true;
            int index = -1;
            for(int j = 0; j < boardSize; j++) {
                ok = ok && (board.getBoard()[j][i] == '\u0000' || board.getBoard()[j][i] == player.getSymbol());
                if(board.getBoard()[j][i] == '\u0000') {
                    index = j;
                }
            }
            if(ok) {
                ans[0] = index;
                ans[1]= i;
                break;
            }
        }
        return ans;
    }
}
