package org.platzi.javatests.util;

public class StringUtil {
    public static String repeat(String str, int times){
        StringBuilder repeat = new StringBuilder();
        for (int i = 0; i < times; i++) {
            repeat.append(str);
        }
        return repeat.toString();
    }
}
