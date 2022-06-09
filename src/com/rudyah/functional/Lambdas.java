package com.rudyah.functional;

import java.util.function.*;

public class Lambdas {

    static class InternalClass {
        void myFunction() {
            System.out.println("hi");
        }
    }

    public static void main(String[] args) {

        // T supplier
        Supplier<Integer> integerSupplier = () -> (int) Math.round(Math.random() * 10);
        IntSupplier intSupplier = () -> (int) Math.round(Math.random() * 10);
        DoubleSupplier doubleSupplier = () -> Math.random() * 10;
        LongSupplier longSupplier = () -> Math.round(Math.random() * 10);

        int anInt = intSupplier.getAsInt();

        // void consumer T
        Consumer<Integer> integerConsumer = System.out::println;
        int rand = integerSupplier.get();
        integerConsumer.accept(rand);

        Consumer<String> stringConsumer = System.out::println;

        Consumer<Boolean> booleanConsumer = System.out::println;

        IntConsumer intConsumer = x -> System.out.println(x);// same for DoubleConsumer, LongConsumer

        // void biConsumer T, U
        BiConsumer<String, String> stringStringBiConsumer = (x, y) -> stringConsumer.accept(x.concat(y));
        stringStringBiConsumer.accept("Hello", "World");

        // boolean predicate T
        Predicate<Integer> integerPredicate = x -> x < 5;
        booleanConsumer.accept(integerPredicate.test(rand));

        IntPredicate intPredicate = x -> x < 6;// same for DoublePredicate, LongPredicate

        // boolean biPredicate T, T
        BiPredicate<Integer, Integer> integerIntegerBiPredicate = (x, y) -> x < y;
        booleanConsumer.accept(integerIntegerBiPredicate.test(8, 3));

        // T unaryOperator T (extends function which is R function T)
        UnaryOperator<Integer> integerUnaryOperator = x -> 2 * x;
        integerConsumer.accept(integerUnaryOperator.apply(2));
        IntUnaryOperator intUnaryOperator = x -> 2 * x;

        Function<Integer, Boolean> integerIntegerFunction = x -> (2 * x) > 5;
        IntFunction<Boolean> intFunction = x -> (2*x) > 5;// same as function just specify return value as type param
        // also DoubleFunction, LongFunction

        // T binaryOperator T, T (extends biFunction which is R biFunction T, U
        BinaryOperator<Integer> binaryOperator = (x, y) -> x - y;
        integerConsumer.accept(binaryOperator.apply(5, 4));

        IntBinaryOperator intBinaryOperator = (x, y) -> x - y;
        intBinaryOperator.applyAsInt(5, 3);

        BiFunction<Integer, Integer, Boolean> integerIntegerBooleanBiFunction= (x, y) -> (x-y) > 0;


        // supplier (get)
        Supplier<Integer> integerSupplier1 = () -> (int) (Math.random() * 10);

        // consumer and biconsumer (accept)

        // predicate and bipredicate (test)

        // function and bifunction (apply)

        // unaryOperator and binaryOperator (apply)
    }
}
