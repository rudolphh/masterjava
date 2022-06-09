package com.rudyah.generics;

import java.util.ArrayList;
import java.util.List;

/**
 *  Generics - writing and using parameterized types
 *
 */
public class GenericExample {

    static private class Crate<T> {
        private T contents;

        public T emptyCrate() {
            return contents;
        }

        public void packCrate(T contents) {
            this.contents = contents;
        }

        // method generic T is independent of class generic T
        public static <T> T sayHi(T t) {
            return t;
        }
    }

    interface Shippable<T> {
        void ship(T t);
    }

    static class SomeClass {}

    static class ShippableAbstractCrate extends SomeClass implements Shippable<Integer> {
        public void ship(Integer i) {
            System.out.println(i);
        }
    }

    static class AnotherClass extends ShippableAbstractCrate {}

    /*
     *  Method Generic (independent of class generic)
     */
    static private class More {
        public static <T> T something(T t) {
            return t;
        }
    }


    public static void main(String[] args) {
        // in the .class file, all references to T are replaced by Object; known as "type erasure"
        // this allows the code to be compatible with old (legacy) java code without generics
        Crate<Integer> crate = new Crate<>();
        crate.packCrate(3);
        System.out.println(crate.emptyCrate());
        System.out.println(crate.sayHi("Hi"));

        Crate<String> crate1 = More.something(new Crate<>());

        /**
         *  Bounded Generic types - an unknown generic type represented with '?' (wildcard)
         *
         */

        List<?> list = new ArrayList<>(List.of("hello"));// unbounded wildcard
        // list.add("hello");// list is immutable for unbounded and upper bounded wildcards
        // list.set(0, "world");// cannot replace either (immutable)
        list.remove(0);// technically can remove but cannot add

        List<? extends CharSequence> list1 = new ArrayList<String>();// wildcard with UPPER bound
        // list.add("hello");// same as unbounded wildcard, upper bounded wildcards make for immutable
        // why? because technically we could then use any object that extends CharSequence but our
        // ArrayList is of type String.

        List<? super ShippableAbstractCrate> list2 = new ArrayList<SomeClass>();// wildcard with LOWER bound
        list2.add(new AnotherClass());
    }

}
