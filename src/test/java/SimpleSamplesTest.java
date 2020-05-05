import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SimpleSamplesTest {
    @Test
    public void charToStringTest() {
        String s = SimpleSamples.charToString('c');
        Assert.assertThat(s, Is.is("c"));
    }

    @Test
    public void intToStringTest() {
        String s = SimpleSamples.intToString(625);
        Assert.assertThat(s, Is.is("625"));
    }

    @Test
    public void charListToString() {
        String s = SimpleSamples.charListToString(Arrays.asList('a', 'b', 'c', 'd'));
        Assert.assertThat(s, Is.is("abcd"));
    }

    @Test
    public void listOfListToListTest() {
        List<String> stringList = SimpleSamples.listOfListToList(Arrays.asList(Arrays.asList("a", "b", "c"), Arrays.asList("d", "e", "f"), Arrays.asList("g", "h", "i")));
        Assert.assertThat(stringList, Is.is(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i")));
    }

    @Test
    public void listOfIntToSumTest() {
        int sum = SimpleSamples.listOfIntToSum(Arrays.asList(5, 6, 2));
        Assert.assertThat(sum, Is.is(13));
    }

    @Test
    public void listOfDoubleToSumTest() {
        double sum = SimpleSamples.listOfDoubleToSum(Arrays.asList(5.1, 6.3, 2.0));
        assertDoubleIs(sum, 13.4);
        sum = SimpleSamples.listOfDoubleToSum(Arrays.asList(4.2, 4.4, 1.4));
        assertDoubleIs(sum, 10);
    }

    private void assertDoubleIs(double actual, double expected) {
        double maxRatio = Math.max(Math.abs(actual - expected) / actual, Math.abs(actual - expected) / expected);
        Assert.assertThat(maxRatio <=0.00001, Is.is(true));
    }

    @Test
    public void listOfBigIntegerToSumTest() {
        BigInteger sum = SimpleSamples.listOfBigIntegerToSum(Arrays.asList(new BigInteger("5"), new BigInteger("6"), new BigInteger("2")));
        assertBigIntegerIs(sum, new BigInteger("13"));
        sum = SimpleSamples.listOfBigIntegerToSum(Arrays.asList(new BigInteger("4"), new BigInteger("3"), new BigInteger("3")));
        assertBigIntegerIs(sum, new BigInteger("10"));
    }

    private void assertBigIntegerIs(BigInteger actual, BigInteger expected) {
        Assert.assertThat(actual.compareTo(expected), Is.is(0));
    }

    @Test
    public void listOfBigDecimalToSumTest() {
        BigDecimal sum = SimpleSamples.listOfBigDecimalToSum(Arrays.asList(new BigDecimal("5.0"), new BigDecimal("6.1"), new BigDecimal("2.5")));
        assertBigDecimalIs(sum, new BigDecimal("13.6"));
        sum = SimpleSamples.listOfBigDecimalToSum(Arrays.asList(new BigDecimal("4"), new BigDecimal("3"), new BigDecimal("3")));
        assertBigDecimalIs(sum, new BigDecimal("10"));
    }

    private void assertBigDecimalIs(BigDecimal actual, BigDecimal expected) {
        Assert.assertThat(actual.compareTo(expected), Is.is(0));
    }

    @Test
    public void listOfIntegerToMaxTest() {
        Optional<Integer> maxOptional = SimpleSamples.listOfIntegerToMax(Arrays.asList(5, 6, 2));
        Assert.assertThat(maxOptional.isPresent(), Is.is(true));
        Assert.assertThat(maxOptional.get(), Is.is(6));
    }

    @Test
    public void listOfDoubleToMaxTest() {
        Optional<Double> maxOptional = SimpleSamples.listOfDoubleToMax(Arrays.asList(5.1, 6.3, 2.0));
        Assert.assertThat(maxOptional.isPresent(), Is.is(true));
        Assert.assertThat(maxOptional.get(), Is.is(6.3));
    }

    @Test
    public void listOfBigIntegerToMaxTest() {
        Optional<BigInteger> maxOptional = SimpleSamples.listOfBigIntegerToMax(Arrays.asList(new BigInteger("5"), new BigInteger("6"), new BigInteger("2")));
        Assert.assertThat(maxOptional.isPresent(), Is.is(true));
        Assert.assertThat(maxOptional.get(), Is.is(new BigInteger("6")));
    }

    @Test
    public void listOfBigDecimalToMaxTest() {
        Optional<BigDecimal> maxOptional = SimpleSamples.listOfBigDecimalToMax(Arrays.asList(new BigDecimal("5.0"), new BigDecimal("6.1"), new BigDecimal("2.5")));
        Assert.assertThat(maxOptional.isPresent(), Is.is(true));
        Assert.assertThat(maxOptional.get(), Is.is(new BigDecimal("6.1")));
    }

    @Test
    public void listOfBigDecimalToCustomMaxTest() {
        Optional<BigDecimal> maxOptional = SimpleSamples.listOfBigDecimalToCustomMax(Arrays.asList(new BigDecimal("7.81"), new BigDecimal("5.19"), new BigDecimal("2.53")));
        Assert.assertThat(maxOptional.isPresent(), Is.is(true));
        Assert.assertThat(maxOptional.get(), Is.is(new BigDecimal("5.19")));
    }
}
