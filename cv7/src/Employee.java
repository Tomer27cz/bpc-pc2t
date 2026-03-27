import java.util.Arrays;

public class Employee implements Comparable<Employee> {
    private String nickname;
    private String email;
    private char[] password;
    private EmployeeType employeeType;

    public Employee(String nickname, String email, char[] password, EmployeeType employeeType) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.employeeType = employeeType;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public int compareTo(Employee other) {
        if (this.email == null && other.email == null) return 0;
        if (this.email == null) return -1;
        if (other.email == null) return 1;
        return this.email.compareTo(other.email);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", employeeType=" + employeeType +
                '}';
    }
}