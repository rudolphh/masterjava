package com.rudyah.collections;

import java.util.*;

// Comparable interface is from java.lang so does NOT require import
public class ComparableClass implements Comparable<ComparableClass>{

    private final String name;
    private final int weight;

    ComparableClass(String name) {
        this.name = name;
        this.weight = 0;
    }

    ComparableClass(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public int compareTo(ComparableClass o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString(){
        return this.name + " - " + this.weight;
    }

    @Override
    public boolean equals(Object o) {
        // 1. check if instancof the object we're comparing for equality
        if(!(o instanceof ComparableClass other)) return false;// pattern matching for instanceof creates local variable
        // 2. check that the field we're using equals the field of the object we're comparing to
        return this.name.equals(other.name);// use local variable 'other' rather than having to cast
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }



    public static void main(String[] args) {
        ComparableClass rudy = new ComparableClass("Rudy", 220);
        ComparableClass imi = new ComparableClass("Imi", 45);
        System.out.println(rudy.compareTo(imi));

        TreeSet<ComparableClass> family = new TreeSet<>(Set.of(rudy, imi));
        System.out.println(family);

        /**
         *  Helper static methods for building a Comparator
         *      - comparing(function) - compare by results of a function that returns any object
         *      - comparingDouble - " " " that returns a double
         *      - comparingInt - " " " that returns a int
         *      - comparingLong - " " " that returns a long
         *      - naturalOrder - sort using the order specified by the Comparable implementation on the object itself
         *      - reverseOrder - reverse of the order specified by the Comparable implementation (on the object itself).
         *
         *  methods that can then be chained
         *      - reversed
         *      - thenComparingFunction
         *      - thenComparingDouble
         *      - thenComparingInt
         *      - thenComparingLong
         */

        // Comparator from java.util so DOES require import (unlike comparable)
        Comparator<ComparableClass> descWeight = (o1, o2) -> o2.weight - o1.weight;// is a functional interface (lambda)
        // can also be written with static helpers in Comparator class
        Comparator<ComparableClass> byNameandDescWeight =
                Comparator.comparing(ComparableClass::getName).thenComparing(ComparableClass::getWeight);

        List<ComparableClass> familyList = new ArrayList<>(family);
        familyList.add(new ComparableClass("Noah", 250));
        familyList.add(new ComparableClass("Sam", 245));
        System.out.println("before sort familyList: " + familyList);
        familyList.sort(descWeight);
        System.out.println("after sort familyList by larger weight: " + familyList);

        familyList.clear();
        familyList.addAll(family);
        familyList.add(new ComparableClass("Noah", 250));
        familyList.add(new ComparableClass("Sam", 245));
        System.out.println("before sort familyList: " + familyList);
        familyList.sort(byNameandDescWeight);
        System.out.println("after sort familyList by name then larger weight: " + familyList);
    }
}
