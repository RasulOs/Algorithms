/*
Java REST GET Simple
In the Java file, write a program to perform a GET request on the route
https://coderbyte.com/api/challenges/json/rest-get-simple and then print to the console the hobbies property in the
following format: ITEM1, ITEM2, ...

Example Output
running, painting

Example of a JSON:

{"name":"John Smith","age":25,"hobbies":["running","coding","camping"]}
*/

package easy;

import java.io.*;
import java.net.*;

public class FindHobbiesInJSON {
    private static HttpURLConnection urlConnection;

    public static void main(String[] args) {

        BufferedReader reader;
        String line = "";
        StringBuilder builder = new StringBuilder();

        try{

            URL url = new URL("https://coderbyte.com/api/challenges/json/rest-get-simple");

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(5000);


            int status = urlConnection.getResponseCode();

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream()));

                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                reader.close();
            } else {

                reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                reader.close();
            }

            System.out.println(builder.toString());
            System.out.println(parseJsonAndReturnHobbies(builder.toString()));


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
    }

    public static String parseJsonAndReturnHobbies(String json) {

        String[] array1 = json.toString()
                .replaceAll("[{}]", "")
                .replaceAll("\"", "")
                .replaceAll("\\[|\\]", "")
                .split(":");

        String[] array2;
        StringBuilder result = new StringBuilder();


        for (int i = 0; i < array1.length; i++) {
            if (array1[i].contains("hobbies")) {
                result.append(array1[i + 1].replaceAll(",", ", "));
            }
        }

        return result.toString();
    }
}
