package regex;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlAttributes {

    static String whitespace_chars = ""       /* dummy empty string for homogeneity */
            + "\\u0009" // CHARACTER TABULATION
            + "\\u000A" // LINE FEED (LF)
            + "\\u000B" // LINE TABULATION
            + "\\u000C" // FORM FEED (FF)
            + "\\u000D" // CARRIAGE RETURN (CR)
            + "\\u0020" // SPACE
            + "\\u0085" // NEXT LINE (NEL)
            + "\\u00A0" // NO-BREAK SPACE
            + "\\u1680" // OGHAM SPACE MARK
            + "\\u180E" // MONGOLIAN VOWEL SEPARATOR
            + "\\u2000" // EN QUAD
            + "\\u2001" // EM QUAD
            + "\\u2002" // EN SPACE
            + "\\u2003" // EM SPACE
            + "\\u2004" // THREE-PER-EM SPACE
            + "\\u2005" // FOUR-PER-EM SPACE
            + "\\u2006" // SIX-PER-EM SPACE
            + "\\u2007" // FIGURE SPACE
            + "\\u2008" // PUNCTUATION SPACE
            + "\\u2009" // THIN SPACE
            + "\\u200A" // HAIR SPACE
            + "\\u2028" // LINE SEPARATOR
            + "\\u2029" // PARAGRAPH SEPARATOR
            + "\\u202F" // NARROW NO-BREAK SPACE
            + "\\u205F" // MEDIUM MATHEMATICAL SPACE
            + "\\u3000" // IDEOGRAPHIC SPACE
            ;
    static String whitespace_charclass = "[" + whitespace_chars + "]";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int to = Integer.valueOf(sc.nextLine());
        TreeMap<String, Set<String>> list = new TreeMap();
        String Test_String = null;
        for (int o = 0; o < to; o++) {

            Test_String = sc.nextLine();
            Test_String.replaceAll(whitespace_charclass, " ");
            Pattern p = Pattern.compile("<.+?>");
            Matcher m = p.matcher(Test_String);

            int Count = 0;
            findInMatcher(list, Test_String, m);
        }
        for (String element : list.keySet()) {
            System.out.print(element + ":");
            Iterator<String> ko = list.get(element).iterator();
            while (ko.hasNext()) {
                System.out.print(ko.next());
                if (ko.hasNext()) {
                    System.out.print(",");
                }
            }
            System.out.println();
        }


    }

    private static void findInMatcher(TreeMap<String, Set<String>> list, String test_String, Matcher m) {
        while (m.find()) {
            int s1 = m.start(0);
            int e1 = m.end(0);
            String elelent = test_String.substring(s1, e1);
            Pattern p2 = Pattern.compile("<(.+?)((?= )(.*=.*))*>");
            Matcher m2 = p2.matcher(elelent);
            if (m2.matches()) {
                if (m2.group(1).startsWith("/"))
                    continue;
                if (m2.group(2) == null) {
                    if (list.get(m2.group(1)) == null) {
                        list.put(m2.group(1), new TreeSet());
                    }
                } else {
                    updateListElements(list, m2);
                }

            }
        }
    }

    private static void updateListElements(TreeMap<String, Set<String>> list, Matcher m2) {
        list.put(m2.group(1), list.get(m2.group(1)));
        String[] result = m2.group(2).split(" ");
        String last = m2.group(1);
        if (list.get(last) == null) {
            list.put(last, new TreeSet());
        }
        if (result.length > 1) {
            for (String element : result) {
                Pattern p3 = Pattern.compile("(.+?)=.*");
                Matcher m3 = p3.matcher(element);
                if (m3.matches()) {
                    list.get(last).add(m3.group(1));
                }

            }
        } else {
            Pattern p3 = Pattern.compile("(.+?)=.*");
            Matcher m3 = p3.matcher(result[0]);
            if (m3.matches()) {
                list.get(last).add(m3.group(1));
            }
        }
    }


}
