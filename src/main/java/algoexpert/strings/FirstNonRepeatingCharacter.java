package algoexpert.strings;

import java.util.HashMap;
import java.util.LinkedHashMap;

// https://www.algoexpert.io/questions/first-non-repeating-character
public class FirstNonRepeatingCharacter {

    public int firstNonRepeatingCharacter(String string) {
        HashMap<Character, Integer> chars = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            chars.compute(string.charAt(i), (k,v) -> (v == null) ? 1 : ++v);
        }
        for (int i = 0; i < string.length(); i++) {
            if (chars.get(string.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
