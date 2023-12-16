package org.platzi.javatests.reto;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.platzi.javatests.reto.Fizzbuzz.TypeFizzBuzz.*;

public class FizzbuzzShould {
    @Test
    public void return_Fizz_when_is_divisible_3() {
        assertEquals(String.valueOf(FIZZ), Fizzbuzz.fizzBuzz(6));
    }
    @Test
    public void return_Buzz_when_is_divisible_5() {
        assertEquals(String.valueOf(BUZZ), Fizzbuzz.fizzBuzz(10));
    }
    @Test
    public void return_FizzBuzz_when_is_divisible_3_and_5() {
        assertEquals(String.valueOf(FIZZBUZZ), Fizzbuzz.fizzBuzz(15));
    }
    @Test
    public void return_Number_when_is_not_3_or_5() {
        assertEquals(String.valueOf(16), Fizzbuzz.fizzBuzz(16));
    }
}