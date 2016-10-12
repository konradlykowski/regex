package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitNumber {
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

        int to = sc.nextInt();
        for (int i = 0; i <= to; i++) {
            String a3 = sc.nextLine();
            a3 = a3.replaceAll(whitespace_charclass, " ");
            a3 = a3.replaceAll("-", " ");
            Pattern p = Pattern.compile("^([0-9]+)\\s([0-9]+)\\s([0-9]+)$");
            Matcher m = p.matcher(a3);

            if (m.matches()) {
                System.out.println("CountryCode="+m.group(1)+",LocalAreaCode="+m.group(2)+",Number="+m.group(3));
            }

        }
    }


}
