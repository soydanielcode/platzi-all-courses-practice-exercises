package org.platzi.javatests.util;

public class StringUtil {
    /**
     * Function to repeat text
     * @param str text to repeat
     * @param times number of times to repeat texts
     * @return String with the repeated words
     **/
    public static String repeat(String str, int times){
        if(times < 0){
            throw new IllegalArgumentException("negative times not allowed");
        }
        return str.repeat(times);
    }
}
