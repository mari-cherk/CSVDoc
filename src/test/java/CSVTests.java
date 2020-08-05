import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CSVTests {

    CSVDocWrite csvDocWrite = new CSVDocWrite();
    CSVDocRead csvDocRead = new CSVDocRead();

    @Test
    public void checkCreatedCSVFileTest(){
        csvDocWrite.writeDataAtOnce("src/newCSVDoc.csv");
        File createdFile = new File("src/newCSVDoc.csv");
        Assert.assertTrue(createdFile.exists());
    }

    @Test
    public void readCSVFileTest(){
        csvDocRead.readAllDataAtOnce("src/newCSVDoc.csv");
    }
}
