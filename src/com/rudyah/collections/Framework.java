package com.rudyah.collections;

import java.util.*;

public class Framework {

    public static void main(String[] args) {

        /**
         * Collections Framework
         *      Functions:
         *          - boolean add(Object o) / boolean add(int index, E element) - equals() determines equality in Set
         *          - E get(int index)
         *          - E set(int index, E element)
         *          - boolean remove(Object o) / boolean remove(int index)
         *          - boolean isEmpty() / int size()
         *          - void clear()
         *          - boolean contains(Object o)
         *          - boolean removeIf(Predicate<? super E> filter)
         *          - void forEach(Consumer<? super T> action)
         *          - void replaceAll(UnaryOperator<E> op)
         */

        Collection<Integer> integerCollection = Arrays.asList(1, 2, 3);
        List<Integer> integerList = Arrays.asList(3, 2, 1);// will model changes to array given but cannot add/remove
        // integerList.add(4);// UnsupportedOperationException


        /*  List Interface  */
        List<Integer> arrayList = new ArrayList<>();
        boolean added = arrayList.add(8);
        arrayList.add(3);
        System.out.println("add 1 : " + arrayList.add(1));
        System.out.println("add 1 : " + arrayList.add(1));// list allows duplicates, ALWAYS returns true
        System.out.println("remove (object) 100 : " + arrayList.remove(Integer.valueOf(100)));// FALSE, using object vs.
        arrayList.remove(1);// using index - will throw IndexOutOfBoundsException if no such index
        System.out.println(arrayList);
        arrayList.clear();
        System.out.println("After clear() : " + arrayList);

        List<Integer> linkedList = new LinkedList<>();
        System.out.println("linkedList isEmpty() : " + linkedList.isEmpty());


        /**
         *  Queue Interface
         *      - Using LinkedList (ArrayDeque for "pure" queue - performance)
         *          - implements both Queue and List interfaces
         *
         *      - Functions:
         *          - boolean add(E element) - insert back of queue (Exception on failure - limited size)
         *          - E element() - return next element (Exception on failure)
         *          - boolean offer(E element) - insert back of queue
         *          - E remove() - removes/returns next element (Exception if empty)
         *          - E poll() - removes/returns next element OR null (if empty)
         *          - E peek() - returns (not remove) next element OR null (if empty)
         */
        Queue<Integer> linkedListQueue = new LinkedList<>();
        System.out.println("linkedListQueue size() : " + linkedListQueue.size());
        linkedListQueue.offer(12);
        linkedListQueue.offer(500);
        linkedListQueue.remove(15);// Queue does not remove by index so autoboxes 15 (Integer.valueOf(15))
        System.out.println("linkedListQueue peek() : " + linkedListQueue.peek());// 12
        System.out.println("linkedListQueue poll() : " + linkedListQueue.poll());// 12
        System.out.println("linkedListQueue poll() : " + linkedListQueue.poll());// 500
        System.out.println("linkedListQueue peek() : " + linkedListQueue.peek());// null

        /**
         *  Set Interface
         *      - HashSet no order but constant O(1) read and insert ( calls hashCode())
         *      - TreeSet - ordered, but O(log n) read and insert ( calls compareTo())
         *
         *      Functions:
         *          - Set.of() - immutable
         *          - Set.copyOf -
         *         note: only set interface functions on exam
         */
        Set<Integer> hashSet = new HashSet<>();
        System.out.println(hashSet.add(3));
        System.out.println(hashSet.add(3));// FALSE, not added bc key exists

        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(8);
        treeSet.add(3);
        treeSet.add(1);
        System.out.println("treeSet contains(Object o) : " + treeSet.contains(8));
        System.out.println(treeSet);// order is maintained within binary tree
        treeSet.removeIf(i -> i < 7);
        System.out.println("after removeIf less than 7 : " + treeSet);


        /**
         *  Creating a list with a factory
         */

        List<Integer> arraysAsList = Arrays.asList(5, 4, 3, 2, 1);// can replace elements but not add/delete
        arraysAsList.set(0, 6);
        System.out.println("arraysAsList after set(0,6) : " + arraysAsList);
        // arraysAsList.add(5);// UnsupportedOperationException
        arraysAsList.replaceAll(x -> x * x);
        System.out.println("arraysAsList after replaceAll(x->x*x) : " + arraysAsList);

        List<Integer> listOf = List.of(8, 7, 6);// cannot add/replace/delete (immutable)
        int indOne = listOf.get(1);
        System.out.println("value at index 1 of listOf : " + indOne);

        List<Integer> listCopyOfCollection = List.copyOf(treeSet);
        System.out.println("listCopyOfCollection : " + listCopyOfCollection);// immutable list copy of collections vals


        /**
         *  Map Interface
         *      - does not implement Collection interface
         *      - not technically a Collection, but is a "collection" - contains a group of objects
         *
         *
         *      - HashMap
         *          - uses hashCode() of keys to retrieve values fast (efficient), but loses order
         *      - TreeMap - maintains order of keys, but less efficient as tree grows (uses compareTo())
         *      - If order is important w/ HashMap, consider LinkedHashMap
         *
         *      Functions:
         *          - Map.of(K1, V1, K2, V2 ...) - INSTEAD use
         *          - Map.ofEntries(Map.Entry(K1, V1), Map.Entry(K2, V2), ...)
         *          - Map.copyOf(Collection c) - same as List or Set
         *
         *          - void clear()
         *          - boolean containsKey(K keyObj) - similar to contains on Collection interface
         *          - boolean containsValue(V valueObj)
         *          - Set<Map.Entry<K,V>> entrySet - returns set of key/value pairs
         *          - void forEach(BiConsumer(K key, V value))
         *          - V get(K key) - return value mapped to a key
         *          - V getOrDefault(K key, V defaultValue) - return value mapped to key, OR value specified as default
         *          - boolean isEmpty() - similar to isEmpty() on Collection interface
         *          - Set<K> keySet() - returns set of keys
         *          - V merge(K key, V value, Function(<V, V> func))
         *              - sets value if key not set
         *              - runs function if key is set to determine new value
         *              - removes key if null
         *
         *          - V put(K key, V value) - adds or replaces key/value pair.  returns prev value OR null
         *          - V putIfAbsent(K key, V value)
         *              - adds value if key not present (returns null), if present returns value
         *
         *          - V remove (K key) - removes and returns value mapped to key.  returns null if no key found
         *          - V replace(K key, V value) - replace value for given key (if set). returns original value or null
         *          - void replaceAll(BiFunction<K, V, V> func) - replace each value with result of function
         *          - int size() - return size
         *          - Collection<V> values() - return Collection of all values.
         */

        Map<Integer, Integer> hashMap = new HashMap<>();

        Map<Integer, Integer> mapOfEntries = Map.ofEntries(
                Map.entry(0, 0),
                Map.entry(1, 1)
        );
        Map<Integer, Integer> treeMap = new TreeMap<>(mapOfEntries);

        System.out.println("mapOfEntries containsKey(0) : " + mapOfEntries.containsKey(0));
        System.out.println("mapOfEntries containsKey(2) : " + mapOfEntries.containsKey(2));
        hashMap = Map.copyOf(mapOfEntries);
        System.out.println(hashMap);
        hashMap.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));
        hashMap.values().forEach(System.out::println);
        hashMap.entrySet().forEach(x -> System.out.println("key: " + x.getKey() + ", value: " + x.getValue()));
        System.out.println("getOrDefault(2, 2) : " + hashMap.getOrDefault(2, 2));// returns default
        System.out.println("replace(0, 2) : " + treeMap.replace(0, 2));// original value 0

        treeMap.replaceAll((k, v) -> k + v);
        System.out.println(treeMap);
        treeMap.putIfAbsent(3, 3);
        treeMap.putIfAbsent(0, 5);
        System.out.println(treeMap);

        treeMap.merge(0, 3, (x, y) -> x < y ? y : null);// change value if current val less than given val
        treeMap.merge(0, 1, (x, y) -> x < y ? y : null);// if current val is greater, remove (return null)
        treeMap.merge(0, 1, (x, y) -> x < y ? y : null);// will add key back bc doesn't exist at this point
        System.out.println(treeMap);

    }
}
