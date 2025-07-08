package org.example.socialmediamvc.utils;

import org.springframework.stereotype.Component;

import java.util.List;


public class CommonUtil {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
    public static boolean isNullOrEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }
}
