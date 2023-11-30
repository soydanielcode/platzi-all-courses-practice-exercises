package org.platzi.javatests.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {
    public static void main(String[] args) {
        repeatTextManualTest();
    }

    @Test
    public void assertEqualsJUnit(){
        Assert.assertEquals("holaholahola", StringUtil.repeat("hola",3));
        Assert.assertEquals("byby", StringUtil.repeat("by",4));
    }

    public static void assertEqualsManual(String actual, String expected){
        if (!actual.equals(expected)){
            throw new RuntimeException(actual + " is not equals to " + expected);
        }
    }
    public static void repeatTextManualTest(){
        String text = StringUtil.repeat("Hola", 5);
        if (text.equals("HolaHolaHolaHolaHola")){
            System.out.println("ok");
        }

        String text1 = StringUtil.repeat("Hola", 3);
        if (!text1.equals("HolaHolaHolaBy")){
            System.out.println("Error");
        }

        String text3 = StringUtil.repeat("Hola", 2);
        assertEqualsManual(text3, "HolaHolaBy");
    }
}