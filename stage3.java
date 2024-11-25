import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<int[]> WINNING_COMBINATIONS = new ArrayList<>();

    static {
        WINNING_COMBINATIONS.add(new int[]{0, 1, 2}); // Row 1
        WINNING_COMBINATIONS.add(new int[]{3, 4, 5}); // Row 2
        WINNING_COMBINATIONS.add(new int[]{6, 7, 8}); // Row 3
        WINNING_COMBINATIONS.add(new int[]{0, 3, 6}); // Column 1
        WINNING_COMBINATIONS.add(new int[]{1, 4, 7}); // Column 2
        WINNING_COMBINATIONS.add(new int[]{2, 5, 8}); // Column 3
        WINNING_COMBINATIONS.add(new int[]{0, 4, 8}); // Diagonal 1
        WINNING_COMBINATIONS.add(new int[]{2, 4, 6}); // Diagonal 2
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.length() != 9) {
            System.out.println("Invalid input. Please enter exactly 9 symbols.");
            return;
        }

        displayGrid(input);

        int xCount = input.replace("O", "").replace("_", "").length();
        int oCount = input.replace("X", "").replace("_", "").length();

        boolean xWins = isWin('X', input);
        boolean oWins = isWin('O', input);

        if ((xWins && oWins) || Math.abs(xCount - oCount) > 1) {
            System.out.println("Impossible");
        } else if (xWins) {
            System.out.println("X wins");
        } else if (oWins) {
            System.out.println("O wins");
        } else if (input.contains("_")) {
            System.out.println("Game not finished");
        } else {
            System.out.println("Draw");
        }
    }

    public static boolean isWin(char player, String input) {
        for (int[] combination : WINNING_COMBINATIONS) {
            if (input.charAt(combination[0]) == player &&
                input.charAt(combination[1]) == player &&
                input.charAt(combination[2]) == player) {
                return true;
            }
        }
        return false;
    }

    public static void displayGrid(String input) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            int index = i * 3;
            String line = input.substring(index, index + 3).replace("_", " ");
            System.out.println("| " + line.charAt(0) + " " + line.charAt(1) + " " + line.charAt(2) + " |");
        }
        System.out.println("---------");
    }
}
