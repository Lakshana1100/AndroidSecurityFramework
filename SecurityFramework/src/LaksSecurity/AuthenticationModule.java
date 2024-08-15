package LaksSecurity;

import java.util.regex.Pattern;

public class AuthenticationModule {

    public static boolean validatePassword(String password) {
        // password policies
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        return Pattern.matches(passwordRegex, password);
    }

    public static boolean isSafeInput(String input) {
        // common SQL injection characters and patterns
        String inputRegex = "^[a-zA-Z0-9_@.]+$"; 
        return Pattern.matches(inputRegex, input);
    }
}