import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        System.out.println(Practice.encode("Success".toLowerCase()));
    }
}


class Practice {
    public static String encode(String word) {
          /*The goal of this exercise is to convert a string to a new string where each character in the new string is "(" if that character appears only once in the original string, or ")" if that character appears more than once in the original string. Ignore capitalization when determining if a character is a duplicate.
            Examples
            "din"      =>  "((("
            "recede"   =>  "()()()"
            "Success"  =>  ")())())"
            "(( @"     =>  "))(("
            Notes
            Assertion messages may be unclear about what they display in some languages. If you read "...It Should encode XXX", the "XXX" is the expected result, not the input!
           */
        Stream<Character> re = word.chars().mapToObj(r -> (char)r);
        return re.map(r -> Pattern
                .compile("\\w{0,}"+String.valueOf(r)+"{2,}"+"\\w{0,}").matcher(word.toLowerCase()).matches() ? ")" : "(")
                .reduce("",(e, g) -> e.concat(g));
    }


    //     Given an array, find the int that appears an odd number of times.
//
//     There will always be only one integer that appears an odd number of times.

    public static int findIt(int[] a) {
        int an = 0;
        for (int t : a) {
            int g1 =  Arrays.stream(a).reduce(0, (a1, b1) -> {
                if(b1 == t) a1++;
                return a1;
            });

            if(g1 % 2 != 0) {
                an = t;
                break;
            } else {
                continue;
            }

        }
        return an;
    }
}


