/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignement4;

import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author dufnill
 */
/**
 * 
 * Class made for testing purpose
 */
public class Main {
    public static void main(String[] args){
        JobScheduler bs = new BookJobScheduler();  
        Stream<AJob<String, String>> emitted= bs.emit();
        Stream<Pair<String, String>> computed = bs.compute(emitted);
        Stream<Pair<String, List<String>>> collected = bs.collect(computed);
        bs.output(collected);
    }
}
