package main.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
Find duplicate elements in the string and return them.

Example:

input: "Happy"
output: "p"

input: "abc"
output: ""

input: "    "
output: ""

input: "!das412$@$@"
output: "$@"

Function should be case insensitive.
*/

public class FindDuplicateElementsInString {

    public static String returnDuplicates(String my_input) {

        // Key is the character that already was processed, boolean indicates if the character was already
        // written to StringBuilder
        Map<Character, Boolean> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        my_input = my_input.trim().toLowerCase();

        for (int i = 0; i < my_input.length(); i++) {
            if (map.containsKey(my_input.charAt(i))) {
                if (!map.get(my_input.charAt(i))) {  // Check if this element was not already in StringBuilder
                    sb.append(my_input.charAt(i));
                    map.put(my_input.charAt(i), true); // To prevent StringBuilder to write duplicate elements several times
                }
            } else {
                map.put(my_input.charAt(i), false); // If the key did not processed before
            }
        }

        return Objects.requireNonNull(sb.toString());
    }
}
