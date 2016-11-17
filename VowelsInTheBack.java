package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class VowelsInTheBack {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String Test_String = sc.next();

        Pattern p = Pattern.compile("^.*([aeiouy])(.)(.)(.)(.)(.)(.)(.)(.)(.)$");
        Matcher m = p.matcher(Test_String);
        int Count = 0;
        while(m.find()){
            Count += 1;
        }
        System.out.format("Number of matches : %d",Count);


    }
}
