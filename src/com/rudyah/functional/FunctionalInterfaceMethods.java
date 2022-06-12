package com.rudyah.functional;

import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaceMethods {

    public static void main(String[] args) {
        Predicate<String> egg = s -> s.contains("egg");
        Predicate<String> brown = s -> s.contains("brown");

        Predicate<String> brownEggs = egg.and(brown);

        String brownEggsAndHam = "brown eggs and ham";
        String greenEggsAndHam = "green eggs and ham";
        System.out.println("egg and brown in 'brown eggs and ham': "  + brownEggs.test(brownEggsAndHam));
        System.out.println("egg and brown in 'green eggs and ham': " + brownEggs.test(greenEggsAndHam));

        Predicate<String> eggsNotBrown = egg.and(brown.negate());
        System.out.println("eggs and NOT brown in 'brown eggs and ham': " + eggsNotBrown.test(brownEggsAndHam));
        System.out.println("eggs and NOT brown in 'green eggs and ham': " + eggsNotBrown.test(greenEggsAndHam));

        Predicate<String> brownOrGreen = brown.or(s -> s.contains("green"));
        System.out.println("brown OR green in 'brown eggs and ham': " + brownOrGreen.test(brownEggsAndHam));
        System.out.println("brown OR green in 'green eggs and ham': " + brownOrGreen.test(greenEggsAndHam));

        Function<String, String> lower = String::toLowerCase;
        Function<String, String> repeat = s-> s.replace("r", "R");
        System.out.println(repeat.compose(lower).apply("RUDY"));// run lower first, output goes as input to repeat
        System.out.println(repeat.andThen(lower).apply("rudy"));// repeat first, then lower

    }
}
