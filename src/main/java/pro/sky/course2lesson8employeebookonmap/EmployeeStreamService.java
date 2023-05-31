package pro.sky.course2lesson8employeebookonmap;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeStreamService {

    private int maxPersonnelNumber = 100;

    private List<Employee> employeeList = new ArrayList<>();

    public EmployeeStreamService() {
    }

    public EmployeeStreamService(int maxPersonnelNumber) {
        this.maxPersonnelNumber = maxPersonnelNumber;
    }

    public int getMaxPersonnelNumber() {
        return maxPersonnelNumber;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    // !! make method to hire some exmaple employees

    public Employee hire(String firstName, String lastName, int deptId, long salary) {

        Employee employee = new Employee(firstName, lastName, "enrolled");

        return employee;
    }


    public String welcome() {
        return "<h2> Course 2, Lesson 9: Stream and Optional<br><br>"

                + "Under construction, sorry</h2>";
        // !! make hint for /deparments/max-salary and other commands !!
    }

    public String maxSalary() {
        return "Under construction";
    }
/**
 public void printDeptCrews() {
 System.out.println("List of personnel by departments");
 int i = 0;
 for (; i < depts.length; i++) {

 System.out.println(depts[i].toString());
 for (int j = 0; j < team.length; j++) {
 if (team[j] != null) {
 if (team[j].getDeptId() == i) {
 System.out.println(team[j].getPerson());
 }
 }
 }

 }
 System.out.println();
 }

 public int getMinSalary() {
 int s = 0;
 boolean firstIteration = true;
 for (Employee employee : team) {
 if (employee != null) {
 if (s > employee.getSalary() || firstIteration) {
 s = employee.getSalary();
 firstIteration = false;
 }
 }
 }
 return s;
 }

 public void printMinSalary() {
 int min = getMinSalary();
 System.out.println("Minimum salary of " + min + " earned by");
 for (Employee employee : team) {
 if ((employee != null) && employee.getSalary() == min) {
 System.out.println(employee);
 }
 }
 System.out.println();
 }

 public int getMaxSalary() {
 int max = 0;
 for (Employee employee : team) {
 if (employee != null) {
 if (max < employee.getSalary()) {
 max = employee.getSalary();
 }
 }
 }
 return max;
 }

 public void printMaxSalary() {
 int max = getMaxSalary();
 System.out.println("Maximum salary of " + max + " earned by");
 for (Employee employee : team) {
 if (employee != null) {
 if (employee.getSalary() == max) {
 System.out.println(employee);
 }
 }
 }
 System.out.println();
 }

 public int getMaxSalaryPosition() {
 int max = getMaxSalary();
 int p = 0;
 int i = 0;
 for (; i < team.length; i++) {
 if (team[i] != null) {
 if (team[i].getSalary() == max) {
 p = i + 1;
 return p;
 }
 }
 }
 return p;
 } */

}
