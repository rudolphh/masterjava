package com.rudyah.functional;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Optionals {

    public static Optional<Double> average(int... scores) {
        if (scores.length == 0) return Optional.empty();
           int sum = 0;
           for (int score: scores) sum += score;
        return Optional.of((double) sum / scores.length);
    }

    public static void main(String[] args) {
        Optional<Double> average = Optional.empty();
        //average.get();// NoSuchElementException
        System.out.println(average.orElse(0.0));
        Double orElseGet = average.orElseGet(() -> 0.0);// excessive in this case but for objects useful

        try {
            //System.out.println(average.orElseThrow());
            System.out.println(average.orElseThrow(()-> new NoSuchElementException("No average?!? What happened")));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(average(90, 100));
        average(50, 80).ifPresent(System.out::println);// ifPresent(Consumer)

        System.out.println(average());
    }
}
