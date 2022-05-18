package utils;

import model.RozetkaFilters;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLToObject {
    public RozetkaFilters convert() {
        RozetkaFilters rozetkaFilters = null;
        try {
            File file = new File("src/test/resources/rozetkaFilters.xml");
            JAXBContext context = JAXBContext.newInstance(RozetkaFilters.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            rozetkaFilters = (RozetkaFilters) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return rozetkaFilters;
    }
}
