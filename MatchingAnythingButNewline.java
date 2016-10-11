package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MatchingAnythingButNewline {


    public static void main(String[] pattern) {

        Scanner scanner = new Scanner(System.in);
        String testString = scanner.nextLine();
        System.out.print("#");
        System.out.print(testString);
        System.out.print("#");
        Pattern p = Pattern.compile("[^\\s]{2}[\\s]{2}[^\\s]{2}[\\s]{2}[^\\s]{2}");
        Matcher m = p.matcher(testString);
        boolean match = m.matches();
        System.out.format("%s", match);
    }


}
