package Board;

import Person.Player;
import Strategies.WinningStrategy;

public class Board {
    private int size;
    private char[][] board;
    public Board setSize(int size) {
        this.size = size;
        this.board = new char[size][size];
        return this;
    }

    public int getSize() {
        return this.size;
    }

    public char[][] getBoard() {
        return  this.board;
    }

    public boolean makeAMove(Player player, WinningStrategy winningStrategy) {
        int[] ans = winningStrategy.winningStrategy(player, this);
        if(ans[0] == -1)
            ans = winningStrategy.defaultStrategy(player, this);
        this.board[ans[0]][ans[1]] = player.getSymbol();
        boolean hasWon = winningStrategy.hasWon(player, this, ans);
        System.out.println(player.getFirstName() + " " + player .getLastName() + "  has marked " + ans[0] + " " + ans[1]);
        if(hasWon) {
            System.out.println(player.getFirstName() + " "  +player.getLastName() + " has won!!");
        }

        return hasWon;
    }
}
