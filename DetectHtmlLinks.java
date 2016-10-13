package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectHtmlLinks {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int to = Integer.valueOf(sc.nextLine());
        for (int lineIndex = 0; lineIndex < to; lineIndex++) {
            String[] lines = sc.nextLine().split("<a ");
            for (String line : lines) {
                Pattern p = Pattern.compile("((href=\"(.*?)\".*?(title=\"(.*?)\"))|(title=\"(.*?)\".*?(href=\"(.*?)\"))|(href=\"(.*?)\")).*?>(.*?)</a>.*");
                Matcher m = p.matcher(line);
                if (m.matches()) {

                    if (m.group(3) != null) {
                        System.out.print(m.group(3));
                        if (m.group(5) != null) {
                            // System.out.print(", " + m.group(5));
                        }
                        if (m.group(m.groupCount()) != null) {
                            singleMatch(m);

                        }
                    }
                    if (m.group(11) != null) {
                        System.out.print(m.group(11));
                        if (m.group(m.groupCount()) != null) {
                            singleMatch(m);
                        }
                    }
                    System.out.println();
                }
            }
        }
    }

    private static void singleMatch(Matcher m) {
        Pattern p2 = Pattern.compile(".*?>(.+?)<.*?");

        Matcher m2 = p2.matcher(m.group(m.groupCount()));

        if (m2.matches()) {
            System.out.print("," + m2.group(m2.groupCount()).trim());
        } else {
            Pattern p3 = Pattern.compile("<.*>");
            Matcher m3 = p3.matcher(m.group(m.groupCount()));
            if (m3.matches()) {
                System.out.print(",");
                return;
            }
            System.out.print("," + m.group(m.groupCount()).trim());
        }
    }
}
