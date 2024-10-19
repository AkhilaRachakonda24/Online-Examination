import java.util.Scanner;  // Add this line to import Scanner

public class Main {
    public static void main(String[] args) {
        // Create a sample user
        User user = new User("user1", "password1", "John Doe");
        SessionManager sessionManager = new SessionManager(user);
        
        Scanner scanner = new Scanner(System.in);  // No more errors after importing Scanner

        // Login
        if (sessionManager.login()) {
            int option;
            do {
                // Main menu
                System.out.println("\nMain Menu:");
                System.out.println("1. Update Profile");
                System.out.println("2. Change Password");
                System.out.println("3. Start Quiz");
                System.out.println("4. Logout");
                System.out.print("Choose an option: ");
                option = scanner.nextInt();
                
                switch (option) {
                    case 1:
                        sessionManager.updateProfile();
                        break;
                    case 2:
                        sessionManager.changePassword();
                        break;
                    case 3:
                        startQuiz();
                        break;
                    case 4:
                        sessionManager.logout();
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } while (option != 4);
        }
    }

    private static void startQuiz() {
        Quiz quiz = new Quiz();

        // Start timer thread for auto-submit
        QuizTimer quizTimer = new QuizTimer(quiz, 30);  // Set timer to 30 seconds
        Thread timerThread = new Thread(quizTimer);
        timerThread.start();

        quiz.takeQuiz();
        timerThread.interrupt(); // End timer thread if quiz finished early
        quiz.showResults();
    }
}
