package org.platzi.javatests.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {
    @Test
    public void assertEqualsJUnit(){
        Assert.assertEquals("holaholahola", StringUtil.repeat("hola",3));
        Assert.assertEquals("bybybyby", StringUtil.repeat("by",4));
    }
}