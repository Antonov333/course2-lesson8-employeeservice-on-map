package pro.sky.course2lesson8employeebookonmap;

import java.util.Objects;

public class Employee implements Comparable<Employee> {
    private final String firstName;
    private final String lastName;
    private int salary;
    private int deptId;
    private String status;

    public String toString() {
        return firstName + " " + lastName + " " + status + " DeptNo: " + deptId + " Salary: " + salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee(String firstName, String lastName, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.deptId = 0;
        this.salary = 0;
    }

    public Employee(String firstName, String lastName, String status, int deptId, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.deptId = deptId;
        this.salary = salary;
    }

    public String getKey() {
        return firstName + lastName;
    }

    public int getSalary() {
        return salary;
    }

    public int getDeptId() {
        return deptId;
    }

    public boolean isDeptId(int deptId) {
        return (deptId == this.deptId);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!other.getClass().equals(this.getClass())) {
            return false;
        }
        return Objects.equals(firstName, ((Employee) other).getFirstName())
                && Objects.equals(lastName, ((Employee) other).getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public int compareTo(Employee o) {
        Integer thisDeptId = new Integer(deptId);
        Integer otherDeptId = new Integer(o.getDeptId());
        return thisDeptId.compareTo(otherDeptId);
    }
}
