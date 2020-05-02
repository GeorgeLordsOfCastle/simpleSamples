import java.util.List;
import java.util.stream.Collectors;

public class SimpleSamples {
    public static String charToString(char c) {
        return String.valueOf(c);
    }

    public static String intToString(int i) {
        return String.valueOf(i);
    }

    public static String charListToString(List<Character> charList) {
        StringBuilder sb = new StringBuilder();
        charList.forEach(sb::append);
        return sb.toString();
    }

    public static List<String> listOfListToList(List<List<String>> listOfList) {
        return listOfList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
