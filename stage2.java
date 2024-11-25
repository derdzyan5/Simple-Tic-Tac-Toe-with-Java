import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine();

        if (input.length() != 9) {
            System.out.println("Invalid input. Please enter exactly 9 symbols.");
            return;
        }

        String firstLine = input.substring(0, 3);
        String secondLine = input.substring(3, 6);
        String thirdLine = input.substring(6, 9);

        System.out.println("---------");

        System.out.println(formatLine(firstLine));
        System.out.println(formatLine(secondLine));
        System.out.println(formatLine(thirdLine));

        System.out.println("---------");
    }

    public static String formatLine(String line) {
        return "| " + line.charAt(0) + " " + line.charAt(1) + " " + line.charAt(2) + " |";
    }
}
