import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class HandlingFilesInTest {
    public static final String MY_FILE_PATH = "src//test//resources//myFile.txt";
    @Test
    public void accessFileWithARelativePath() throws FileNotFoundException {
        new FileInputStream(MY_FILE_PATH);
    }
}
