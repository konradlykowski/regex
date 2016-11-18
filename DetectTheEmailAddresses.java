package regex;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DetectTheEmailAddresses {

    public static void main(String[] args) {

        Set<String> list = new TreeSet();
        Scanner sc = new Scanner(System.in);
        int to = Integer.valueOf(sc.nextLine());
        for (int lineIndex = 0; lineIndex < to; lineIndex++) {
            String[] words = sc.nextLine().split("((\\p{Space})|(\\s))");

            for(String word: words) {
                Pattern p = Pattern.compile("([a-zA-Z_0-9.]+@\\w+.[a-zA-Z]{2,3}+(.[a-zA-Z]{2,3})*)\\W*");
                Matcher m = p.matcher(word);

                if (m.matches()) {
                    list.add(m.group(1));
                }
            }
        }
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()){
            String element = iter.next();
            System.out.print(element);
            if(iter.hasNext()){
                System.out.print(";");
            }
        }

    }
}
