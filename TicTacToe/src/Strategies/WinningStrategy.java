package Strategies;

import Board.Board;
import Person.Player;

public abstract  class WinningStrategy {
    public abstract int[] winningStrategy(Player player, Board board);

    public int[] defaultStrategy(Player player, Board board) {
        char[][] boardState = board.getBoard();
        int boardSize = board.getSize();
        int[] locationToBeMarked = {-1, - 1};

        for(int row = 0; row < boardSize; row++) {
            for(int col = 0; col < boardSize; col++) {
                if(boardState[row][col] == '\u0000') {
                    locationToBeMarked[0] = row;
                    locationToBeMarked[1] = col;
                    return locationToBeMarked;
                }
            }
        }

        return locationToBeMarked;
    }

    public boolean hasWon(Player player, Board board, int[] ans) {
        char[][] boardState = board.getBoard();
        boolean ok1 = true, ok2 = true, ok3 = true, ok4 = true;
        int serialNo, size = board.getSize();

        for(serialNo = 0; serialNo < size; serialNo++) {
            if(boardState[serialNo][serialNo] != player.getSymbol()) ok1 = false;
            if(boardState[serialNo][ans[1]] != player.getSymbol()) ok2 = false;
            if(boardState[ans[0]][serialNo] != player.getSymbol()) ok3 = false;
            if(boardState[serialNo][size - 1 - serialNo] != player.getSymbol()) ok4 = false;
        }

        return ok1 || ok2 || ok3 || ok4;
    }
}
