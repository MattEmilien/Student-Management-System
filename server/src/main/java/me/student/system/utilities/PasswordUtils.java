package me.student.system.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordUtils {

    public static String generateSalt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] saltBytes = new byte[16]; // 16 bytes is a common size for salts
        secureRandom.nextBytes(saltBytes);
        return bytesToHex(saltBytes);
    }

    // Method to hash the password using SHA-256 and the provided salt
    public static String hashPassword(String plainTextPassword, String salt) throws NoSuchAlgorithmException {
        String saltedPassword = plainTextPassword + salt;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedPasswordBytes = md.digest(saltedPassword.getBytes());
        return bytesToHex(hashedPasswordBytes);
    }

    // Helper method to convert bytes to a hexadecimal string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
