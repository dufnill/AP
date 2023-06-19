/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignement4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author dufnill
 */
/**
 * 
 * BookJobScheduler is a concrete implementation of the JobScehduler
 * it was made 'ad hoc' to handle .txt files, in order to build a dictionary 
 * containing the 'ciao' of all the words in the files and return their repetition.
 * 
 */
public class BookJobScheduler extends JobScheduler {
    
    @Override
    public <K, V> Stream<AJob<K, V>> emit() {
        
        //The user have to insert the path to the directory
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il percorso della cartella: ");
        String dir_path = scanner.nextLine();
        
        //check if the path is linked to a directory
        File folder = new File(dir_path);
        if (!folder.isDirectory()) {
            System.out.println("The path is not related to a valid directory");
            return Stream.empty();
        }
        
        //chekc if the directory is empty
        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("Directory is empty");
            return Stream.empty();
        }
        
        //the directory contains files
        return Stream.of(files)
                .filter(file -> file.isFile() && file.getName().endsWith(".txt"))
                .map(file -> new BookJob<K, V>(file.getPath()));
    }

    @Override
    public <K, V> void output(Stream<Pair<K, List<V>>> collected) {
        try (FileWriter writer = new FileWriter("./count_anagrams.txt")) {
            collected.forEach(pair -> {
                String line = pair.getKey() + " - " + pair.getValue().size();
                try {
                    writer.write(line + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
