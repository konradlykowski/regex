package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FindWhiteSpaceJava {

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

        String Test_String = sc.nextLine();

        Test_String = Test_String.replaceAll(whitespace_charclass, "+");
        System.out.println(Test_String + "^(?'open'o)+(?'-open'c)+$");
        Pattern p = Pattern.compile("");
        Matcher m = p.matcher(Test_String);
        int Count = 0;
        while (m.find()) {
            Count += 1;

        }
        System.out.println("Number of matches : " + Count);
        if (m.matches())
            for (int i = 0; i < m.groupCount(); i++) {
                System.out.println(m.group(i) + "#");
            }
        while (m.find()) {
            for (int i = 1; i <= m.groupCount(); i++) {
                System.out.println(m.group(i));
            }
        }

    }
}
