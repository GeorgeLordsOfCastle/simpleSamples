import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
}
