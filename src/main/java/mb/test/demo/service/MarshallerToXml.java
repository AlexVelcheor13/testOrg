package mb.test.demo.service;

import mb.test.demo.models.Organizations;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;

public class MarshallerToXml {
    public static void organizationMarshaling(Organizations r) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Organizations.class);
        javax.xml.bind.Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(r, new File("src\\main\\resources\\files\\organization.xml"));
    }
}
