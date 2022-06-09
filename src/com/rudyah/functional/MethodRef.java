package com.rudyah.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class MethodRef {

    public static void main(String[] args) {

        /**
         *  There are four formats for method references:
         *      - Static methods
         *      - Instance methods on a particular instance
         *      - Instance methods on a parameter to be determined at runtime
         *      - Constructors
         */

        // calling static methods
        Consumer<List<Integer>> methodRef = Collections::sort;
        Consumer<List<Integer>> lambda = x -> Collections.sort(x);// redundant

        List<Integer> aList = new ArrayList<>(Arrays.asList(3, 2, 1));
        methodRef.accept(aList);
        aList.forEach(System.out::println);

        // calling instance methods on a particular object
        var str = "abc";
        Predicate<String> stringPredicateMethodRef = str::startsWith;
        Predicate<String> stringPredicateLambda = s -> str.startsWith(s);

        // calling instance methods on a parameter
        Predicate<String> stringPredicateMethodRef1 = String::isEmpty;// isEmpty takes no param so java infers instance
        Predicate<String> stringPredicateLambda1 = s -> s.isEmpty();

        BiPredicate<String, String> stringStringBiPredicate = String::startsWith;// instance is first, param second
        System.out.println("Rudy starts with 'R': " + stringStringBiPredicate.test("Rudy", "R"));
        System.out.println("Rudy starts with 'E': " + stringStringBiPredicate.test("Rudy", "E"));

        // Constructors
        UnaryOperator<List<String>> listUnaryOperatorMethodRef = ArrayList::new;// will supply new ArrayList
        UnaryOperator<List<String>> listUnaryOperator = x -> new ArrayList<>(x);
        List<String> list = listUnaryOperatorMethodRef.apply(List.of("Hello", "World"));


    }
}
