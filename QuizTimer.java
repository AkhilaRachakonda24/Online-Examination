public class QuizTimer implements Runnable {
    private Quiz quiz;
    private long timeLimit; // in seconds

    public QuizTimer(Quiz quiz, long timeLimit) {
        this.quiz = quiz;
        this.timeLimit = timeLimit;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(timeLimit * 1000);  // Wait for the time limit
            System.out.println("\nTime is up! Auto-submitting your answers...");
            quiz.autoSubmit();               // Auto-submit answers when time is up
        } catch (InterruptedException e) {
            System.out.println("Quiz submitted early.");
        }
    }
}
