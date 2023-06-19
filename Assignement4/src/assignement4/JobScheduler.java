/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignement4;

import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;


/**
 *
 * @author dufnill
 *
 *
 */

/* 
 *
 * JobScheduler abstract class rapresent the template 
 *
 */
public abstract class JobScheduler{
    
    /* hot spots */
    public abstract <K,V> Stream<AJob<K, V>> emit();
    public abstract <K,V> void output(Stream<Pair<K, List<V>>> collected);
    /* ---------------- */
    
    /* frozen spots */
    public <K,V> Stream<Pair<K, V>> compute(Stream<AJob<K, V>> emitted){
        return emitted.flatMap(AJob::execute);
    }
    
    public <K,V> Stream<Pair<K, List<V>>> collect(Stream<Pair<K, V>> computed) {
        Map<K, List<V>> groupedMap = computed.collect(Collectors.groupingBy(Pair::getKey, Collectors.mapping(Pair::getValue, Collectors.toList())));
        return groupedMap.entrySet().stream()
                .map(entry -> new Pair<>(entry.getKey(), entry.getValue()));
    }
    
    public static void main(String[] args) {
        System.out.println("Hello");   
    }
    /* ------------ */
}  

 