package mb.test.demo.service;

import mb.test.demo.models.Organizations;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class UnmarshallerXML {
    public static Organizations orgUnmarshaling() throws JAXBException {
        String filePath = "src\\main\\resources\\files\\organization.xml";
        File f = new File(filePath);
        JAXBContext jaxbContext = JAXBContext.newInstance(Organizations.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Organizations r = (Organizations) unmarshaller.unmarshal(f);
        return r;
    }
}
