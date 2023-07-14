package mb.test.demo.models;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Organizations {

    @XmlElement(name="Employees")
    private ArrayList<Employee> employees = new ArrayList<>();

    @XmlElement(name="Organizations")
    private ArrayList<Organization> organizations = new ArrayList<>();

    public Organizations() {
    }

    public ArrayList<Organization> getOrganizations() {
        return organizations;
    }

    public boolean addToOrgList(Organization o) {
        return organizations.add(o);
    }
}
