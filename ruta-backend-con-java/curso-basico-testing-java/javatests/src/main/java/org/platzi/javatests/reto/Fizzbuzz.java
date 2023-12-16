package org.platzi.javatests.reto;

import static org.platzi.javatests.reto.Fizzbuzz.TypeFizzBuzz.*;

public class Fizzbuzz {
    public enum TypeFizzBuzz{
        FIZZ, BUZZ, FIZZBUZZ
    }
    public static String fizzBuzz(int n) {
        if(n % 3 == 0 && n % 5 != 0) return String.valueOf(FIZZ);
        if(n % 5 == 0 && n % 3 != 0) return String.valueOf(BUZZ);
        if(n % 3 == 0) return String.valueOf(FIZZBUZZ);
        else return String.valueOf(n);
    }
}
