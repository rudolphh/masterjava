package com.rudyah.functional;

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

        System.out.println(average(90, 100));
        System.out.println(average());
    }
}
