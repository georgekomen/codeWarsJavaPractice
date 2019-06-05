import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        System.out.println(Practice.encode("Success".toLowerCase()));
    }
}


class Practice {
    public static String encode(String word) {
        Stream<Character> re = word.chars().mapToObj(r -> (char)r);
        return re.map(r -> Pattern
                .compile("\\w{0,}"+String.valueOf(r)+"{2,}"+"\\w{0,}").matcher(word.toLowerCase()).matches() ? ")" : "(")
                .reduce("",(e, g) -> e.concat(g));
    }
}
