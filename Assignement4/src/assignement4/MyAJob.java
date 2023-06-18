/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignement4;

import java.util.stream.Stream;

/**
 *
 * @author dufnill
 */
public class MyAJob<K, V> extends AJob<K, V> {

    private K key;
    private V value;

    public MyAJob(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void doSomething() {
        // Additional functionality specific to MyAJob
        System.out.println("Doing something with MyAJob");
    }

    @Override
    public Stream<Pair<K, V>> execute() {
        return Stream.of(new Pair<>(key, value));
    }
}
