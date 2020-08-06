import java.io.File;
import java.util.List;

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
        csvDocRead.csvPrintingValue("src/newCSVDoc.csv", "Suraj");
        List <String[]> newList = csvDocRead.csvExtractingValue("src/newCSVDoc.csv", "10");
        for (String[] row : newList) {
            for (String cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }
}
