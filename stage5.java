import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] grid = new char[9];
        for (int i = 0; i < 9; i++) {
            grid[i] = ' ';
        }
        displayGrid(grid);
        boolean isXTurn = true;

        while (true) {
            String input;
            int row, col;
            int index;

            do {
                System.out.print("Enter the coordinates: ");
                input = scanner.nextLine();
                String[] tokens = input.split("\\s+");

                if (tokens.length != 2) {
                    System.out.println("You should enter numbers!");
                    continue;
                }

                try {
                    row = Integer.parseInt(tokens[0]);
                    col = Integer.parseInt(tokens[1]);
                } catch (NumberFormatException e) {
                    System.out.println("You should enter numbers!");
                    continue;
                }

                if (row < 1 || row > 3 || col < 1 || col > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }

                index = (row - 1) * 3 + (col - 1);

                if (grid[index] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }

                break;
            } while (true);

            if (isXTurn) {
                grid[index] = 'X';
            } else {
                grid[index] = 'O';
            }

            displayGrid(grid);

            String result = checkWin(grid);
            if (!result.equals("Game not finished")) {
                System.out.println(result);
                break;
            }

            isXTurn = !isXTurn;
        }
    }

    public static void displayGrid(char[] grid) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.println("| " + grid[i * 3] + " " + grid[i * 3 + 1] + " " + grid[i * 3 + 2] + " |");
        }
        System.out.println("---------");
    }

    public static String checkWin(char[] grid) {
        int[][] winningCombinations = {
            {0, 1, 2}, 
            {3, 4, 5}, 
            {6, 7, 8}, 
            {0, 3, 6}, 
            {1, 4, 7}, 
            {2, 5, 8}, 
            {0, 4, 8}, 
            {2, 4, 6}  
        };

        for (int[] combo : winningCombinations) {
            if (grid[combo[0]] == 'X' && grid[combo[1]] == 'X' && grid[combo[2]] == 'X') {
                return "X wins";
            }
            if (grid[combo[0]] == 'O' && grid[combo[1]] == 'O' && grid[combo[2]] == 'O') {
                return "O wins";
            }
        }

        for (char c : grid) {
            if (c == ' ') {
                return "Game not finished";
            }
        }

        return "Draw";
    }
}
