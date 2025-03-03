package Strategies;

import Board.Board;
import Person.Player;

public class DiagonalWinningStrategy extends WinningStrategy {

    public static DiagonalWinningStrategy diagonalWinningStrategy;
    private DiagonalWinningStrategy() {}

    public static DiagonalWinningStrategy getInstance() {
        if(diagonalWinningStrategy == null) {
            synchronized (DiagonalWinningStrategy.class) {
                if(diagonalWinningStrategy == null)
                    diagonalWinningStrategy = new DiagonalWinningStrategy();
            }
        }
        return diagonalWinningStrategy;
    }

    @Override
    public int[] winningStrategy(Player player, Board board) {
        int boardSize = board.getSize(), rowTobeMarked = -1;
        char[][] boardState = board.getBoard();
        int[] locationToBeMarked = {-1, -1};

        boolean ok = true;
        for(int row = 0; row < boardSize; row++) {
            ok = ok && (boardState[row][row] == '\u0000' || boardState[row][row] == player.getSymbol());
            if(boardState[row][row] == '\u0000') {
                rowTobeMarked = row;
            }
        }

        if(ok) {
            locationToBeMarked[0] = rowTobeMarked;
            locationToBeMarked[1] = rowTobeMarked;
        }

        rowTobeMarked = -1;
        for(int row = 0; row < boardSize; row++) {
            ok = ok && (boardState[row][boardSize - 1 - row] == '\u0000' || boardState[row][boardSize - 1 - row] == player.getSymbol());
            if(boardState[row][boardSize - 1 - row] == '\u0000') {
                rowTobeMarked = row;
            }
        }

        if(ok) {
            locationToBeMarked[0] = rowTobeMarked;
            locationToBeMarked[1] = rowTobeMarked;
        }

        return locationToBeMarked;
    }
}
