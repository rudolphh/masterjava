package com.rudyah.collections;

import java.util.*;

public class SortAndSearch {

    static class Rabbits { // implements Comparable<Rabbits> {
        int id;
        Rabbits(){}

        Rabbits(int x) {
            id = x;
        }
        @Override
        public String toString() {
            return "" + id;
        }

        public int getId() {
            return id;
        }

//        @Override
//        public int compareTo(Rabbits o) {
//            return id - o.id;
//        }
    }

    public static void main(String[] args) {
        List<Rabbits> rabbits = new ArrayList<>();
        rabbits.add(new Rabbits());
        rabbits.add(new Rabbits(3));
        //rabbits.sort(Comparator.comparingInt(x -> x.id).reversed());
        System.out.println(rabbits);
        // if not comparable use a comparator
        System.out.println(Collections.binarySearch(rabbits, new Rabbits(0 ), Comparator.comparing(Rabbits::getId)));

        // cannot use a tree (TreeMap or TreeSet) without implementing comparable interface, OR providing comparator
        Set<Rabbits> rabbitsSet = new TreeSet<>(Comparator.comparing(Rabbits::getId));
        rabbitsSet.add(new Rabbits(8));// ClassCastException because no comparable (Trees use compareTo)
        rabbitsSet.add(new Rabbits(3));
        System.out.println(rabbitsSet);


    }
}
