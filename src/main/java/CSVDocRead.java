import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class CSVDocRead {

    public void readAllDataAtOnce(String file)
    {
        try {
            // Create an object of file reader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(file);

            // create csvReader object and skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();

            // print Data
            for (String[] row : allData) {
                for (String cell : row) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void csvPrintingValue(String file, String text) {
        // to get country code of Guyana from csv file
        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            List<String[]> list = reader.readAll();
            for (String[] line : list) {
                if (line[0].equals(text)) {
                    System.out.println(line[1] + "\t" + line[2]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String[]> csvExtractingValue(String file, String text) {
        List<String[]> neededList = new ArrayList<String[]>();
        // to get country code of Guyana from csv file
        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            List<String[]> list = reader.readAll();
            for (String[] line : list) {
                if (line[1].equals(text)) {
                    String[] newLine = new String[3];
                    newLine[0] = line[0];
                    newLine[1] = line[1];
                    newLine[2] = line[2];
                    neededList.add(newLine);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return neededList;
    }
}
