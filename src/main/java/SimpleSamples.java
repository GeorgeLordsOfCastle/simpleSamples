import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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

    public static Optional<Integer> listOfIntegerToMax(List<Integer> integerList) {
        return integerList.stream().max(Integer::compareTo);
    }

    public static Optional<Double> listOfDoubleToMax(List<Double> doubleList) {
        return doubleList.stream().max(Double::compareTo);
    }

    public static Optional<BigInteger> listOfBigIntegerToMax(List<BigInteger> bigIntegerList) {
        return bigIntegerList.stream().max(BigInteger::compareTo);
    }

    public static Optional<BigDecimal> listOfBigDecimalToMax(List<BigDecimal> bigDecimalList) {
        return bigDecimalList.stream().max(BigDecimal::compareTo);
    }

    public static Optional<BigDecimal> listOfBigDecimalToCustomMax(List<BigDecimal> bigDecimalList) {
        return bigDecimalList.stream().max(Comparator.comparing(SimpleSamples::getSumOfFirstAndSecondDecimalDigits));
    }

    private static int getSumOfFirstAndSecondDecimalDigits(BigDecimal bigDecimal) {
        int twoDecimalDigits = bigDecimal.subtract(new BigDecimal(bigDecimal.intValue()))
                .multiply(new BigDecimal("100"))
                .intValue();
        return twoDecimalDigits/10 + twoDecimalDigits%10;
    }

}
