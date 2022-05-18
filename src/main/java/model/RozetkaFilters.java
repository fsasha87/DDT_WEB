package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "rozetkaFilters")
@XmlAccessorType(XmlAccessType.FIELD)
public class RozetkaFilters {

    @XmlElement(name = "rozetkaFilter")
    private List<RozetkaFilter> rozetkaFilters = null;

    public List<RozetkaFilter> getRozetkaFilters() {
        return rozetkaFilters;
    }

}
