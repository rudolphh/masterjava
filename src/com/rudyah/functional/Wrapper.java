package com.rudyah.functional;

import java.util.ArrayList;
import java.util.List;

public class Wrapper {

    public static void main(String[] args) {

        // careful when unboxing
        var heights = new ArrayList<Integer>();
        heights.add(null);
        //int h = heights.get(0);// NullPointerException

        // remove is overloaded for index and object.  be mindful which is being used
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(Integer.valueOf(3));
        numbers.add(Integer.valueOf(5));
        numbers.remove(1);// removes number at index 1 (3)
        numbers.remove(Integer.valueOf(5));// removes number with value of 5
        System.out.println(numbers);// prints 1

    }
}
