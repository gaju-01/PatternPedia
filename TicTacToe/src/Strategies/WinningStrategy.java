package Strategies;

import Board.Board;
import Person.Player;

public abstract  class WinningStrategy {
    public abstract int[] winningStrategy(Player player, Board board);

    public int[] defaultStrategy(Player player, Board board) {
        char[][] boardState = board.getBoard();
        int boardSize = board.getSize();
        int[] ans = {-1, - 1};

        for(int i = 0; i < boardSize; i++) {
            for(int j = 0; j < boardSize; j++) {
                if(boardState[i][j] == '\u0000') {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }

        return ans;
    }

    public boolean hasWon(Player player, Board board, int[] ans) {
        char[][] boardState = board.getBoard();
        boolean ok1 = true, ok2 = true, ok3 = true, ok4 = true;
        int i, size = board.getSize();

        for(i = 0; i < size; i++) {
            if(boardState[i][i] != player.getSymbol()) ok1 = false;
            if(boardState[i][ans[1]] != player.getSymbol()) ok2 = false;
            if(boardState[ans[0]][i] != player.getSymbol()) ok3 = false;
            if(boardState[i][size - 1 - i] != player.getSymbol()) ok4 = false;
        }

        return ok1 || ok2 || ok3 || ok4;
    }
}
