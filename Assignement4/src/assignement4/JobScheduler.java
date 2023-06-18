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
 */
public class JobScheduler {
    
    public static final Integer POSSIBLE_KEYS = 100;
    public static final Integer STRING_LENGTH = 10;
    public static final Integer STREAM_LENGTH = 1000;


    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String generateString(int length) {
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }   
    
    public static int generateInt(int upper) {
        Random random = new Random();
        return random.nextInt(upper);
    }
    
    public static MyAJob<Integer, String> generateJob(int possibleKeys, int strLength){
        MyAJob<Integer, String> job = new MyAJob<>(generateInt(possibleKeys), generateString(strLength));
        return job;
        
    }
    
    public static Stream<MyAJob<Integer, String>> emit() {
        return Stream.generate(() -> generateJob(POSSIBLE_KEYS,STRING_LENGTH)).limit(STREAM_LENGTH);
    }

    public static Stream<Pair<Integer, String>> compute (Stream<MyAJob<Integer, String>> emitted){
        return emitted.flatMap(MyAJob::execute);
    } 
    
    public static Stream<Pair<Integer, List<String>>> collect(Stream<Pair<Integer, String>> computed) {
        Map<Integer, List<String>> groupedMap = computed.collect(Collectors.groupingBy(Pair::getKey, Collectors.mapping(Pair::getValue, Collectors.toList())));
        return groupedMap.entrySet().stream()
                .map(entry -> new Pair<>(entry.getKey(), entry.getValue()));
    }
    
    private static void output(Stream<Pair<Integer, List<String>>> collected) {
        collected.forEach(job -> System.out.println("Key: " + job.getKey() + ", Value: " + job.getValue()));
    }
    
    public static void main(String[] args) {
        output(collect(compute(emit())));

    }

}  
