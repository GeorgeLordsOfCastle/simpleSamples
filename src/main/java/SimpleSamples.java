import java.math.BigDecimal;
import java.math.BigInteger;
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

    public static Integer listOfIntToSum(List<Integer> integerList) {
        return integerList.stream().reduce(0, Integer::sum);
    }

    public static Double listOfDoubleToSum(List<Double> doubleList) {
        return doubleList.stream().reduce(0.0, Double::sum);
    }

    public static BigInteger listOfBigIntegerToSum(List<BigInteger> bigIntegerList) {
        return bigIntegerList.stream().reduce(BigInteger.ZERO, BigInteger::add);
    }

    public static BigDecimal listOfBigDecimalToSum(List<BigDecimal> bigDecimalList) {
        return bigDecimalList.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
