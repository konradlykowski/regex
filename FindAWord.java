package regex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FindAWord {

    public static void main(String[] args) {

        HashMap<String, Integer> tokens = new LinkedHashMap<>();
        HashMap<String, Integer> results = new LinkedHashMap<>();

        Scanner sc = new Scanner(System.in);
        int to = Integer.valueOf(sc.nextLine());
        for (int lineIndex = 0; lineIndex < to; lineIndex++) {
            String[] mayWords = sc.nextLine().split("((\\p{Space})|(\\s))");
            for (String mayWord : mayWords) {
                if (tokens.containsKey(mayWord)) {
                    tokens.put(mayWord.trim(), tokens.get(mayWord) + 1);
                } else {
                    tokens.put(mayWord, 1);
                }
            }

        }
        int to2 = Integer.valueOf(sc.nextLine());
        for (int lineIndex = 0; lineIndex < to2; lineIndex++) {
            String word = sc.nextLine().trim();

            for (String token : tokens.keySet()) {
                Pattern p = Pattern.compile(".*((?=\\W)+|^|.*[(.-])(" + word + ")([).-].*|(?=\\W)+|$).*");

                Matcher m = p.matcher(token);

                if (m.matches()) {
                    if (results.containsKey(word)) {
                        int num = results.get(word);
                        results.put(word, ++num);
                    } else {
                        results.put(word, 1);
                    }

                }

            }

        }
        for (String el : results.keySet()) {
            System.out.println(results.get(el));
        }
    }
}
