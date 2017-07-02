import question1.IPValidationRegex;
import question2.SortStudentInfo;
import question3.TimeConsumingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by markz on 2/7/17.
 */
public class Solution {

    public static void main(String[] args){
        Solution solution = new Solution();

        solution.question1();
        solution.question2();
        solution.question3();

    }

    private void question1() {

        System.out.println("Results for Q1:");

        IPValidationRegex ipValidationRegex = new IPValidationRegex();

        Set<String> ipSamples = resultFromFile("ipAddresses.txt", false);

        Set<String> invalidAddresses = ipSamples.stream().filter(ipValidationRegex::isValidIP).collect(Collectors.toSet());

        System.out.println("Invalid addresses: " + invalidAddresses);
    }

    private void question2(){
        System.out.println("Results for Q2:");

        SortStudentInfo sortStudentInfo = new SortStudentInfo();

        Set<String> students = resultFromFile("studentInfo.txt", true);

        String results = sortStudentInfo.sort(students);

        System.out.println("Results: " + results);
    }

    private void question3(){
        System.out.println("Results for Q3:");
        TimeConsumingTest timeConsumingTest = new TimeConsumingTest();
        timeConsumingTest.execute();
    }

    private Set<String> resultFromFile(String fileName, boolean skipFirstLine){
        //Read samples
        InputStream in = getClass().getClassLoader().getResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Set<String> results = new HashSet<>();

        String line = null;
        try {

            if(skipFirstLine){
                reader.readLine();
            }

            while((line = reader.readLine()) != null){
                results.add(line);
            }

        } catch (IOException e) {
            System.out.println("Error happened when reading: " + fileName);
        }

        return results;
    }

}
