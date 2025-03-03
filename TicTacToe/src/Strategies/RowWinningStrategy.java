package Strategies;

import Board.Board;
import Person.Player;

public class RowWinningStrategy extends WinningStrategy {

    public static RowWinningStrategy rowWinningStrategy;
    private RowWinningStrategy() {}

    public static RowWinningStrategy getInstance() {
        if(rowWinningStrategy == null) {
            synchronized (RowWinningStrategy.class) {
                if(rowWinningStrategy == null)
                    rowWinningStrategy = new RowWinningStrategy();
            }
        }
        return rowWinningStrategy;
    }
    @Override
    public int[] winningStrategy(Player player, Board board) {
        int boardSize = board.getSize();
        char[][] boardState = board.getBoard();;
        int[] locationToBeMarked = {-1, -1};

        for(int row = 0; row < boardSize; row++) {
            boolean ok = true;
            int columTobeMarked = -1;
            for(int col = 0; col < boardSize; col++) {
                ok = ok && (boardState[row][col] == '\u0000' || boardState[row][col] == player.getSymbol());
                if(boardState[row][col] == '\u0000') {
                    columTobeMarked = col;
                }
            }
            if(ok) {
                locationToBeMarked[0] = row;
                locationToBeMarked[1]= columTobeMarked;
                break;
            }
        }
        return locationToBeMarked;
    }
}
