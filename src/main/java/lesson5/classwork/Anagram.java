package lesson5.classwork;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Anagram {

    private char[] chars;

    public static void main(String[] args) {
        Set<String> result = new Anagram().getAnagrams("cat");
        for (String anagram : result) {
            System.out.println(anagram);
        }
    }

    private Set<String> getAnagrams(String word) {
        if (word.length() == 1) {
            return Collections.singleton(word);
        }

        this.chars = word.toCharArray();
        Set<String> result = new HashSet<>();

        collectAnagrams(word.length(), result);
        return result;
    }

    private void collectAnagrams(int length, Set<String> result) {
        if (length == 1) {
            return;
        }

        for (int i = 0; i < length; i++) {
            collectAnagrams(length - 1, result);
            result.add(String.valueOf(chars));
            rotate(length);
        }
    }

    private void rotate(int length) {
        int pos = chars.length - length;
        char temp = chars[pos];

        for (int i = pos + 1; i < chars.length; i++) {
            chars[i - 1] = chars[i];
        }
        chars[chars.length - 1] = temp;
    }
}
