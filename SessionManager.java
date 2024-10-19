import java.util.Scanner;  // Add this line to import Scanner

public class SessionManager {
    private User user;
    private boolean isLoggedIn;
    
    public SessionManager(User user) {
        this.user = user;
        this.isLoggedIn = false;
    }

    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        
        if (user.authenticate(username, password)) {
            isLoggedIn = true;
            System.out.println("Login successful! Welcome, " + user.getProfileName() + ".");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }

    public void updateProfile() {
        if (isLoggedIn) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter new profile name: ");
            String newName = scanner.nextLine();
            user.setProfileName(newName);
            System.out.println("Profile name updated successfully.");
        } else {
            System.out.println("Please login first.");
        }
    }

    public void changePassword() {
        if (isLoggedIn) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter new password: ");
            String newPassword = scanner.nextLine();
            user.setPassword(newPassword);
            System.out.println("Password updated successfully.");
        } else {
            System.out.println("Please login first.");
        }
    }

    public void logout() {
        if (isLoggedIn) {
            isLoggedIn = false;
            System.out.println("Logged out successfully.");
        } else {
            System.out.println("No active session to logout.");
        }
    }
}
