import java.util.HashMap;
import java.util.Scanner;

public class Quiz {
    private HashMap<Integer, String> questions;
    private HashMap<Integer, String> correctAnswers;
    private HashMap<Integer, String> userAnswers;

    public Quiz() {
        questions = new HashMap<>();
        correctAnswers = new HashMap<>();
        userAnswers = new HashMap<>();
        loadQuestions();
    }

    private void loadQuestions() {
        // Load MCQ Questions
        questions.put(1, "What is the capital of France?\nA) Paris\nB) Rome\nC) London\nD) Berlin");
        questions.put(2, "What is 2 + 2?\nA) 3\nB) 4\nC) 5\nD) 6");
        questions.put(3, "Who developed Java?\nA) Microsoft\nB) Sun Microsystems\nC) Google\nD) Apple");

        // Load correct answers
        correctAnswers.put(1, "A");
        correctAnswers.put(2, "B");
        correctAnswers.put(3, "B");
    }

    public void takeQuiz() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= questions.size(); i++) {
            System.out.println(questions.get(i));
            System.out.print("Your answer: ");
            String answer = scanner.next().toUpperCase();
            userAnswers.put(i, answer);
        }
    }

    public void autoSubmit() {
        if (userAnswers.size() < questions.size()) {
            System.out.println("Auto-submitting incomplete answers...");
            for (int i = 1; i <= questions.size(); i++) {
                if (!userAnswers.containsKey(i)) {
                    userAnswers.put(i, "No Answer");
                }
            }
        }
    }

    public void showResults() {
        int score = 0;
        for (int i = 1; i <= questions.size(); i++) {
            String correctAnswer = correctAnswers.get(i);
            String userAnswer = userAnswers.get(i);
            System.out.println("Question " + i + ": " + (userAnswer.equals(correctAnswer) ? "Correct" : "Wrong"));
            if (userAnswer.equals(correctAnswer)) {
                score++;
            }
        }
        System.out.println("Final Score: " + score + "/" + questions.size());
    }
}
