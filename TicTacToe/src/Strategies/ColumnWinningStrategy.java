package Strategies;

import Board.Board;
import Person.Player;

public class ColumnWinningStrategy extends WinningStrategy {

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
        int[] locationToBeMarked = {-1, -1};

        for(int col = 0; col < boardSize; col++) {
            boolean ok = true;
            int rowTobeMarked = -1;
            for(int row = 0; row < boardSize; row++) {
                ok = ok && (board.getBoard()[row][col] == '\u0000' || board.getBoard()[row][col] == player.getSymbol());
                if(board.getBoard()[row][col] == '\u0000') {
                    rowTobeMarked = row;
                }
            }
            if(ok) {
                locationToBeMarked[0] = rowTobeMarked;
                locationToBeMarked[1]= col;
                break;
            }
        }
        return locationToBeMarked;
    }
}
