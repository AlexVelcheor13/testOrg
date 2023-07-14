package mb.test.demo.models;

import mb.test.demo.adapter.LocalDateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.List;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
    @XmlElement(name = "fullName")
    @XmlID
    private String fullName;
    @XmlElement(name = "birthDate")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate birthDate;
    @XmlTransient
    private List<Organization> organizations;

    public Employee() {
    }

    public Employee(String fullName, LocalDate birthDate, List<Organization> organizations) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.organizations = organizations;
    }

    public Employee(String fullName, LocalDate birthDate) {
        this.fullName = fullName;
        this.birthDate = birthDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }
        @Override
        public String toString() {
            return "Employee{" +
                    "fullName='" + fullName + '\'' +
                    ", birthDate=" + birthDate +
                    '}';
        }
}




