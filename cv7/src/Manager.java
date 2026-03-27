import java.util.ArrayList;
import java.util.List;

public class Manager<T> extends Employee {
    private List<Employee> listOfEmployees;
    private List<T> listOfRelationships;

    public Manager(String nickname, String email, char[] password, EmployeeType employeeType) {
        super(nickname, email, password, employeeType);
        this.listOfEmployees = new ArrayList<>();
        this.listOfRelationships = new ArrayList<>();
    }

    public void addEmployee(Employee emp) {
        this.listOfEmployees.add(emp);
    }

    public void addRelationship(T relationship) {
        this.listOfRelationships.add(relationship);
    }

    public List<Employee> getListOfEmployees() {
        return listOfEmployees;
    }

    public List<T> getListOfRelationships() {
        return listOfRelationships;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "email='" + getEmail() + '\'' +
                ", employeesCount=" + listOfEmployees.size() +
                ", relationshipsCount=" + listOfRelationships.size() +
                '}';
    }
}