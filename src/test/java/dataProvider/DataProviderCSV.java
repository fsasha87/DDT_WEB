package dataProvider;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataProviderCSV {
    @DataProvider(name = "DpCSVReader", parallel = true)
    public static Object[][] csvDataRead(){
        List<String[]> listData = null;
        try (CSVReader reader = new CSVReader(new FileReader("src/test/resources/data.csv"))) {
            listData = reader.readAll();
//            r.forEach(x -> System.out.println(Arrays.toString(x)));
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return listData.stream().map(i -> new Object[]{i[0], i[1], i[2]}).toArray(Object[][]::new);
    }

}
