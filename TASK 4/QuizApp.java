//Quiz Application with Timer
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp {
    
    static class Question {
        String question;
        String[] options;
        int correctAnswer; // Index of the correct answer in options array

        Question(String question, String[] options, int correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
    }

    static List<Question> questions = new ArrayList<>();
    static int score = 0;
    static int currentQuestionIndex = 0;
    static boolean timeUp = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Add sample questions
        questions.add(new Question("What is the capital of France?", new String[]{"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"}, 2));
        questions.add(new Question("Who wrote 'Hamlet'?", new String[]{"1. Charles Dickens", "2. William Shakespeare", "3. Mark Twain", "4. Jane Austen"}, 1));
        questions.add(new Question("What is 2 + 2?", new String[]{"1. 3", "2. 4", "3. 5", "4. 6"}, 1));

        // Iterate through questions
        for (currentQuestionIndex = 0; currentQuestionIndex < questions.size(); currentQuestionIndex++) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            System.out.println(currentQuestion.question);
            for (String option : currentQuestion.options) {
                System.out.println(option);
            }
            
            Timer timer = new Timer();
            timeUp = false;
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    timeUp = true;
                    System.out.println("\nTime's up!");
                }
            }, 10000); // 10 seconds timer for each question

            int userAnswer = -1;
            while (!timeUp && (userAnswer < 1 || userAnswer > 4)) {
                System.out.print("Your answer (1-4): ");
                if (scanner.hasNextInt()) {
                    userAnswer = scanner.nextInt();
                } else {
                    scanner.next(); // Clear the invalid input
                }
            }
            timer.cancel();
            
            if (userAnswer - 1 == currentQuestion.correctAnswer && !timeUp) {
                score++;
            }

            if (timeUp) {
                System.out.println("You did not answer in time.");
            }
        }

        // Display the final score and summary
        System.out.println("Quiz over!");
        System.out.println("Your final score is: " + score + "/" + questions.size());
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println((i + 1) + ". " + q.question);
            System.out.println("Correct answer: " + q.options[q.correctAnswer]);
            System.out.println();
        }
        scanner.close();
    }
}
// Code by Vivek Auti

