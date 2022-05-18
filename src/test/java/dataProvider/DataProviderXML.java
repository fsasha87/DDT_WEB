package dataProvider;

import model.RozetkaFilter;
import model.RozetkaFilters;
import org.testng.annotations.DataProvider;
import utils.XMLToObject;

import java.util.List;

public class DataProviderXML {

    @DataProvider(name = "DpXML", parallel = true)
    public static Object[][] xmlDataRead() {
        XMLToObject xmlToObject = new XMLToObject();
        RozetkaFilters rozetkaFilters = xmlToObject.convert();
        List<RozetkaFilter> rozetkaFilterList = rozetkaFilters.getRozetkaFilters();
        return rozetkaFilterList.stream().map(i -> new Object[]{i.getThing(), i.getBrand(), i.getAmount()}).toArray(Object[][]::new);
    }
}
