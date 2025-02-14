import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlayerGameInteractive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strategyKeys = {"row-winning-strategy", "col-winning-strategy", "dia-winning-strategy"};

        System.out.println("Enter the dimensions of the board");
        int size = scanner.nextInt();
        Board board = new Board().setSize(size);

        Player player1 = new Player().setSymbol('+');
        System.out.println("Enter the first name of the player1");
        player1.setFirstName(scanner.next());
        System.out.println("Enter the last name of the player1");
        player1.setLastName(scanner.next());

        Player player2 = new Player().setSymbol('-');
        System.out.println("Enter the first name of the player2");
        player2.setFirstName(scanner.next());
        System.out.println("Enter the last name of the player2");
        player2.setLastName(scanner.next());

        Map<String, WinningStrategy> winningStrategyMap = new HashMap<>();
        winningStrategyMap.put(strategyKeys[0], new RowWinningStrategy());
        winningStrategyMap.put(strategyKeys[1], new ColumnWinningStrategy());
        winningStrategyMap.put(strategyKeys[2], new DiagonalWinningStrategy());

        int moves = size * size;
        while(moves-- != 0) {
            System.out.println("Please choose your winning strategy");
            System.out.println("0: " + strategyKeys[0] + " 1: " + strategyKeys[1] + " 2: "  + strategyKeys[2]);
            int moveIndex = scanner.nextInt();
            boolean hasWon;
            if(moves % 2 == 0) hasWon  = board.makeAMove(player1, winningStrategyMap.get(strategyKeys[moveIndex]));
            else hasWon = board.makeAMove(player2, winningStrategyMap.get(strategyKeys[moveIndex]));
            if(hasWon) break;
        }

        System.out.println("***********************GAME-OVER*******************************");
    }
}
