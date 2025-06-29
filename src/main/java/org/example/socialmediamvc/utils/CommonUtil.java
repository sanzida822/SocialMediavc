package org.example.socialmediamvc.utils;

import org.springframework.stereotype.Component;


public class CommonUtil {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
