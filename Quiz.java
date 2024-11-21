import java.util.Scanner;

public class Quiz {

    // intro method
    public static void displayQuiz() {
        System.out.println("  \n Multiple Choice Quiz");
        System.out.println("----- (a) (b) (c) -----\n");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int testScore = 0;
        int testScoreTotal = 60;

        char[] multipleChoice = {'a', 'b', 'c'};
        String[] testQuestions = {
                "How many days are in one week?",
                "How many days are in one year?",
                "How many seconds are in one hour?"
        };

        String[] testAnswers = {"b", "c", "a"};
        String[][] choices = {{"5 days", "7 days", "9 days"},
                {"356 days", "389 days", "365 days"},
                {"3600 seconds", "4200 seconds", "2800 seconds"}};

        displayQuiz();

        // Loops through questions & multiple choice answers
        for (int i = 0; i < testQuestions.length; i++) {
            System.out.println(testQuestions[i]);
            for (int j = 0; j < choices.length; j++) {
                System.out.print("(" + multipleChoice[j] + ") " +
                        choices[i][j] + " ");
            }

            // User input with try-catch
            String answer;
            try {
                System.out.print("\n\nEnter answer: ");
                answer = scan.nextLine().toLowerCase();

                // Validate answer
                if (!(answer.equals("a") || answer.equals("b") || answer.equals("c"))) {
                    throw new IllegalArgumentException("Invalid answer! " +
                            "Please enter 'a', 'b', or 'c'.");
                }

                // Correct answers
                if (answer.equals(testAnswers[i])) {
                    System.out.println("✅ Correct\n");
                    testScore += 20;
                } else {
                    System.out.println("❌ Incorrect\n"); // Wrong answers
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                i--; // Retry the same question
            }
        }

        // Print test score
        System.out.println("Test score: " + testScore + " / " + testScoreTotal);

        // Feedback based on score
        switch (testScore) {
            case 20:
                System.out.println("Low score... try again!");
                break;
            case 40:
                System.out.println("Ahh... so close to a perfect score!");
                break;
            case 60:
                System.out.println("Great job superstar! 🌟");
                break;
            default:
                System.out.println("Did you even try bro? 🤦🏽‍");
                break;
        }

        // Close scanner
        scan.close();
    }
}
