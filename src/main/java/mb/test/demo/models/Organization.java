package mb.test.demo.models;

import mb.test.demo.adapter.LocalDateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "organization")
@XmlAccessorType(XmlAccessType.FIELD)
public class Organization {
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "dateOfCreation")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate dateOfCreation;
    @XmlElement(name = "status")
    private boolean status;
    @XmlElementWrapper(name="Employees")
    @XmlElement(name="Employee")
    private List<Employee> employees;

    public Organization() {
    }

    public Organization(String name, LocalDate dateOfCreation, boolean status, List<Employee> employees) {
        this.name = name;
        this.dateOfCreation = dateOfCreation;
        this.status = status;
        this.employees = employees;
    }
        public Organization(String name, LocalDate dateOfCreation, boolean status) {
            this.name = name;
            this.dateOfCreation = dateOfCreation;
            this.status = status;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return status == that.status && Objects.equals(name, that.name) && Objects.equals(dateOfCreation, that.dateOfCreation) && Objects.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfCreation, status, employees);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "name='" + name + '\'' +
                ", dateOfCreation=" + dateOfCreation +
                ", status=" + status +
                ", employees=" + showEmplName(employees) +
                '}';
    }

    public List<String> showEmplName(List<Employee> emp) {
        List<String> empNames = new ArrayList<>();
        for (Employee employee : emp) {
            String name = employee.getFullName();
            empNames.add(name);
        }
        return empNames;
    }

}
