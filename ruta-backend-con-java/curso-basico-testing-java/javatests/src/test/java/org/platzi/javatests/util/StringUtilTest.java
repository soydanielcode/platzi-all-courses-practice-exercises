package org.platzi.javatests.util;
public class StringUtilTest {
    public static void main(String[] args) {
        String text = StringUtil.repeat("Hola", 5);
        if (text.equals("HolaHolaHolaHolaHola")){
            System.out.println("ok");
        }
        String text1 = StringUtil.repeat("Hola", 3);
        if (!text1.equals("HolaHolaHolaBy")){
            System.out.println("Error");
        }
    }
}