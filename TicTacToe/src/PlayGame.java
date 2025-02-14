import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PlayGame {

    public static void main(String[] args) {
        int moves = 9;
        Random random = new Random();
        Board board = new Board().setSize(3);
        String[] strategyKeys = {"row-winning-strategy", "col-winning-strategy", "dia-winning-strategy"};

        Player player1 = new Player().setFirstName("Rahul").setLastName("Nayak").setSymbol('+');
        Player player2 = new Player().setFirstName("Dan").setLastName("Morris").setSymbol('-');

        Map<String, WinningStrategy> winningStrategyMap = new HashMap<>();
        winningStrategyMap.put(strategyKeys[0], new RowWinningStrategy());
        winningStrategyMap.put(strategyKeys[1], new ColumnWinningStrategy());
        winningStrategyMap.put(strategyKeys[2], new DiagonalWinningStrategy());

        while(moves-- != 0) {
            int moveIndex = random.nextInt(3);
            boolean hasWon;
            if(moves % 2 == 0) hasWon  = board.makeAMove(player1, winningStrategyMap.get(strategyKeys[moveIndex]));
            else hasWon = board.makeAMove(player2, winningStrategyMap.get(strategyKeys[moveIndex]));
            if(hasWon) break;
        }
    }
}