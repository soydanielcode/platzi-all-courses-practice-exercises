package org.platzi.javatests.util;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.platzi.javatests.util.PasswordUtil.SecurityLevel.*;

public class PasswordUtilTest {
    @Test
    public void weak_when_has_less_than_8_letters(){
        assertEquals(WEAK, PasswordUtil.assessPassword("a!12dfr"));
    }
    @Test
    public void weak_when_only_letters(){
        assertEquals(WEAK, PasswordUtil.assessPassword("adfsdfaAEDFEEew"));
    }
    @Test
    public void medium_when_has_letters_and_numbers(){
        assertEquals(MEDIUM, PasswordUtil.assessPassword("adfsdfaAEDF2332332"));
    }
    @Test
    public void strong_when_contains_letters_numbers_symbols(){
        assertEquals(STRONG, PasswordUtil.assessPassword("adfsdfa!$AEDF2332332"));
    }
}