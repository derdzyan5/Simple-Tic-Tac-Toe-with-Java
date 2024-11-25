import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String grid = scanner.nextLine();

        displayGrid(grid);

        while (true) {
            System.out.print("Enter the coordinates: ");
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");

            if (tokens.length != 2) {
                System.out.println("You should enter numbers!");
                continue;
            }

            try {
                int r = Integer.parseInt(tokens[0]);
                int c = Integer.parseInt(tokens[1]);

                if (r < 1 || r > 3 || c < 1 || c > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }

                int index = (r - 1) * 3 + (c - 1);

                if (grid.charAt(index) != '_') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }

                char[] chars = grid.toCharArray();
                chars[index] = 'X';
                grid = new String(chars);

                displayGrid(grid);
                break;

            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }
        }
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
