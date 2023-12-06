package org.platzi.javatests.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {
    @Test
    public void repeat_once_times(){
        Assert.assertEquals("hola123_", StringUtil.repeat("hola123_",1));
    }
    @Test
    public void repeat_multiple_times(){
        Assert.assertEquals("holaholahola", StringUtil.repeat("hola",3));
    }
    @Test
    public void repeat_zero_times(){
        Assert.assertEquals("", StringUtil.repeat("hola", 0));
    }
    @Test(expected = IllegalArgumentException.class)
    public void repeat_string_negative_times(){
        StringUtil.repeat("hola", -1);
    }

    @Test
    public void string_is_empty_with_characters() {
        assertFalse(StringUtil.isEmpty("string"));
    }
    @Test
    public void string_is_empty_without_characters() {
        assertTrue(StringUtil.isEmpty(""));
    }
    @Test
    public void string_is_empty_when_is_null() {
        assertTrue(StringUtil.isEmpty(null));
    }
    @Test
    public void string_is_empty_with_space() {
        assertTrue(StringUtil.isEmpty("       "));
    }
}