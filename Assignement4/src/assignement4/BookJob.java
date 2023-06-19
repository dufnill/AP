/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignement4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author dufnill
 */
public class BookJob<K, V> extends AJob<K, V> {
    
    private String path_title;
    private String letters = "abcdefghijklmnopqrstuvwxyz";
    
    public BookJob (String path_title){
        this.path_title = path_title;
    }
    
    public String ciaoify(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    
    @Override
    
    public Stream<Pair<K, V>> execute() {
        List<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path_title))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split(" ");    
                for (String word : lineWords) {
                    
                    word = word.toLowerCase();
                    word = word.replaceAll("[^a-zA-Z]", "");

                    if (!word.isEmpty() && word.length() > 4) {
                        words.add(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return words.stream()
                .map(word -> new Pair<>((K) (ciaoify(word.toLowerCase())), (V) word.toLowerCase()));
    }

}
