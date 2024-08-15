package LaksSecurity;

import javax.crypto.SecretKey;
import java.util.Scanner;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Welcome to the Security Framework App");
            System.out.println("1. Encrypt and Decrypt Data");
            System.out.println("2. Check Authorization");
            System.out.println("3. Validate Password Strength");
            System.out.print("Please choose an option (1-3): ");
            int choice = getIntInput(scanner);

            switch (choice) {
                case 1:
                    handleEncryption(scanner);
                    break;
                case 2:               
                    handleAuthorization(scanner);
                    break;
                case 3:
                    handleAuthentication(scanner);
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number (1-3): ");
            }
        }
    }

    private static void handleEncryption(Scanner scanner) throws Exception {
        SecretKey key = EncryptionModule.generateKey();
        System.out.print("Please enter sensitive data to encrypt: ");
        String originalData = scanner.nextLine();
        byte[] encryptedData = EncryptionModule.encryptData(originalData, key);
        String decryptedData = EncryptionModule.decryptData(encryptedData, key);

        System.out.println("Original Data: " + originalData);
        System.out.println("Encrypted Data: " + new String(encryptedData));
        System.out.println("Decrypted Data: " + decryptedData);
    }

    private static void handleAuthorization(Scanner scanner) {
        Set<String> roles = AuthorizationModule.getAllRoles();
        System.out.println("Available Roles:");
        int roleIndex = 1;
        for (String role : roles) {
            System.out.println(roleIndex++ + ". " + role);
        }
    
        System.out.print("Select your role by number: ");
        int roleChoice = Integer.parseInt(scanner.nextLine()) - 1;
        if (roleChoice < 0 || roleChoice >= roles.size()) {
            System.out.println("Number selected isn't from the options provided. Please try again.");
            return;  
        }
        String userRole = (String) roles.toArray()[roleChoice];
    
        Set<String> permissions = AuthorizationModule.getPermissionsByRole(userRole);
        System.out.println("Permissions available for " + userRole + ":");
        int permIndex = 1;
        for (String perm : permissions) {
            System.out.println(permIndex++ + ". " + perm);
        }
    
        System.out.print("Select the permission to check by number: ");
        int permChoice = Integer.parseInt(scanner.nextLine()) - 1;
        if (permChoice < 0 || permChoice >= permissions.size()) {
            System.out.println("Number selected isn't from the options provided. Please try again.");
            return;  
        }
        String permission = (String) permissions.toArray()[permChoice];
    
        boolean hasPermission = AuthorizationModule.hasPermission(userRole, permission);
        System.out.println("User Role: " + userRole + " - Has '" + permission + "': " + hasPermission);
    }    

    private static void handleAuthentication(Scanner scanner) {
        System.out.println("Please enter your password to validate: ");
        System.out.println(" ");
        System.out.println("Password must include a special character in [@#$%^&+=!], capital letter, number and be a minimum of 8 characters");
        System.out.println(" ");
        String password = scanner.nextLine();
        boolean isValidPassword = AuthenticationModule.validatePassword(password);
        System.out.println("Password '" + password + "' is valid: " + isValidPassword);
    }
}