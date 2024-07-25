import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        greetUser();
        String name = askName(scanner);
        guessAge(scanner);
        countToNumber(scanner);
        testProgrammingKnowledge(scanner);

        scanner.close();
    }

    private static void greetUser() {
        System.out.println("Hello!");
    }

    private static String askName(Scanner scanner) {
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        System.out.println("Nice to meet you, " + name + "!");
        return name;
    }

    private static void guessAge(Scanner scanner) {
        System.out.println("What year did you graduate high school?");
        int hsg;
        while (true) {
            if (scanner.hasNextInt()) {
                hsg = scanner.nextInt();
                scanner.nextLine();  // Consume newline left-over
                break;
            } else {
                System.out.println("Please enter a valid year:");
                scanner.next();  // Consume the invalid input
            }
        }

        int hsa = (2024 - hsg) + 18;
        System.out.println("Are you " + hsa + " years old? (yes/no)");
        String a = scanner.nextLine().trim().toLowerCase();

        if (a.equals("yes")) {
            System.out.println("Fantastic");
        } else {
            System.out.println("Let's narrow it down. What was the first video game console you remember playing?");
            String console = scanner.nextLine().trim().toLowerCase();

            int ageGuess = 0;
            if (console.contains("atari")) {
                ageGuess = (2024 - hsg) + 18 + 6; // Assume they are older
            } else if (console.contains("nes") || console.contains("nintendo")) {
                ageGuess = (2024 - hsg) + 18 + 3; // Assume they are slightly older
            } else if (console.contains("playstation")) {
                ageGuess = (2024 - hsg) + 18; // Keep the same age
            } else if (console.contains("xbox")) {
                ageGuess = (2024 - hsg) + 18 - 3; // Assume they are slightly younger
            } else {
                ageGuess = (2024 - hsg) + 18 - 6; // Default adjustment for newer consoles
            }

            System.out.println("Based on your answer, are you around " + ageGuess + " years old? (yes/no)");
            String newAnswer = scanner.nextLine().trim().toLowerCase();

            if (newAnswer.equals("yes")) {
                System.out.println("Fantastic");
            } else {
                System.out.println("Sorry, I couldn't guess your age accurately.");
            }
        }
    }

    private static void countToNumber(Scanner scanner) {
        System.out.println("Please enter a number to count to:");
        int number;
        while (true) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                break;

            } else {
                System.out.println("Please enter a valid number:");
            }
        }

        for (int i = 1; i <= number; i++) {
            System.out.println(i);
        }
    }

    private static void testProgrammingKnowledge(Scanner scanner) {
        System.out.println("Let's test your programming knowledge!");
        System.out.println("Which of the following is a valid Java data type?");
        System.out.println("1. integer");
        System.out.println("2. real");
        System.out.println("3. char");
        System.out.println("4. array");

        int correctAnswer = 3;
        int userAnswer = 0;

        while (userAnswer != correctAnswer) {
            if (scanner.hasNextInt()) {
                userAnswer = scanner.nextInt();

                if (userAnswer == correctAnswer) {
                    System.out.println("Correct! 'char' is a valid Java data type.");
                } else {
                    System.out.println("Incorrect. Please try again.");
                }
            } else {
                System.out.println("Please enter a valid number (1-4):");
            }
        }
    }
}
