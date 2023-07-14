package mb.test.demo.runner;

import mb.test.demo.models.Employee;
import mb.test.demo.models.Organization;
import mb.test.demo.models.Organizations;
import mb.test.demo.service.MarshallerToXml;
import mb.test.demo.service.UnmarshallerXML;

import javax.xml.bind.JAXBException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataCreator {
    static Organizations organizations = new Organizations();

    static {
        List<Organization> first = new ArrayList<>();
        List<Organization> second = new ArrayList<>();
        List<Organization> third = new ArrayList<>();

        List<Employee> arsenalEmp = new ArrayList<>();
        List<Employee> liverpoolEmp = new ArrayList<>();
        List<Employee> manchesterEmp = new ArrayList<>();
        List<Employee> beverenEmp = new ArrayList<>();

        Employee alex = new Employee("Alex", LocalDate.of(1999, 10, 10), first);
        Employee bob = new Employee("Bob", LocalDate.of(1998, 10, 11), first);
        Employee colin = new Employee("Colin", LocalDate.of(1997, 11, 12), second);
        Employee din = new Employee("Din", LocalDate.of(1996, 11, 13), second);
        Employee evan = new Employee("Evan", LocalDate.of(1995, 12, 14), third);
        Employee frank = new Employee("Frank", LocalDate.of(1994, 12, 15), third);

        Organization arsenal = new Organization("Arsenal", LocalDate.of(1886, 01, 01), true, arsenalEmp );
        Organization liverpool = new Organization("Liverpool", LocalDate.of(1892, 01, 01), true, liverpoolEmp );
        Organization manchester = new Organization("Manchester", LocalDate.of(1878, 01, 01), true, manchesterEmp );
        Organization beveren = new Organization("Beveren", LocalDate.of(1934, 01, 01), false, beverenEmp );

        //add Organization
        first.add(arsenal);
        second.add(liverpool);
        second.add(manchester);
        third.add(beveren);
        third.add(liverpool);

        //add Employee
        arsenalEmp.add(alex);
        arsenalEmp.add(bob);
        liverpoolEmp.add(colin);
        liverpoolEmp.add(din);
        liverpoolEmp.add(frank);
        manchesterEmp.add(colin);
        manchesterEmp.add(din);
        beverenEmp.add(evan);
        beverenEmp.add(frank);

        organizations.addToOrgList(arsenal);
        organizations.addToOrgList(liverpool);
        organizations.addToOrgList(manchester);
        organizations.addToOrgList(beveren);
    }

    public static void main(String[] args) throws JAXBException {
        System.out.println("преобразуем объекты в xml");
        MarshallerToXml.organizationMarshaling(organizations);

        System.out.println("преобразуем xml в объекты");
        Organizations orgsFromXml = UnmarshallerXML.orgUnmarshaling();
        for (Organization o: orgsFromXml.getOrganizations()) {
            if (o.isStatus() != false) {
                System.out.println(o);
            }
        }
    }
}
