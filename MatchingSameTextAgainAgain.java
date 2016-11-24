package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MatchingSameTextAgainAgain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String Test_String = sc.next();

        Pattern p = Pattern.compile("(\\p{Lower})(\\w)(\\s)(\\W)(\\d)(\\D)(\\p{Upper})(\\p{L})([aeiouAEIOU])(\\S)\\1\\2\\3\\4\\5\\6\\7\\8\\9\\10");
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
