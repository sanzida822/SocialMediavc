package org.example.socialmediamvc.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class PasswordUtil {
    public static String HashPassword(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }
}

//    public static boolean checkPassword(String plainPassword, String hashedPassword) {
//        return BCrypt.verifyer().verify(plainPassword.toCharArray(), hashedPassword).verified;
//    }

