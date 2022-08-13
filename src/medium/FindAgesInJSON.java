/*
Java Age Counting
In the Java file, write a program to perform a GET request on the route
https://coderbyte.com/api/challenges/json/age-counting which contains a data key and the value is a string
which contains items in the format: key=STRING, age=INTEGER. Your goal is to count how many items exist
that have an age equal to or greater than 50, and print this final value.

Example Input
{"data":"key=IAfpK, age=58, key=WNVdi, age=64, key=jp9zt, age=47"}

Example Output
2

Example of a JSON:

{"data":"key=IAfpK, age=58, key=WNVdi, age=64, key=jp9zt, age=47, key=0Sr4C, age=68, key=CGEqo, age=76"}

*/


package medium;

import java.net.*;
import java.util.*;
import java.io.*;

public class FindAgesInJSON {

    public static void main(String[] args) {

        System.getProperty("http.agent", "Chrome");

        try {
            URL url = new URL("https://coderbyte.com/api/challenges/json/age-counting");

            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String input = "";

            int count = 0;

            StringBuilder sb = new StringBuilder();

            while (input != null) {
                sb.append(input);
                input = in.readLine();
            }

            System.out.println(sb.toString());

            in.close();

            String[] array1 = sb.toString()
                    .replaceAll("[{}]", "")
                    .replaceAll("\"", "")
                    .split(",");

            for (String word: array1) {

                String[] array2 = word.split("=");

                if (array2[0].contains("age") && Integer.parseInt(array2[1]) >= 50)
                    count++;
            }

            System.out.println("Number of people with age more than 50 is: " + count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
