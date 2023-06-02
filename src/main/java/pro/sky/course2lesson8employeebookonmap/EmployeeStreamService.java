package pro.sky.course2lesson8employeebookonmap;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class EmployeeStreamService {

    private int maxPersonnelNumber = 100;

    private int personnelCount = 0;

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

    public Employee hire(String firstName, String lastName, int deptId, int salary) {

        NameCheck nameCheck = new NameCheck(firstName, lastName);

        if (!nameCheck.isOk()) {
            throw new WrongNameFormatException();
        }
        ;

        if (personnelCount >= maxPersonnelNumber) {
            throw new EmployeeStorageIsFullException();
        } else {
            personnelCount++;
        }

        Employee employee = new Employee(firstName, lastName, Status.hired, deptId, salary);

        if (findEmployee(employee)) {
            throw new EmployeeAlreadyAddedException();
        }

        boolean add = employeeList.add(employee);

        Employee e = employeeList.get(personnelCount - 1);

        return e;
    }

    public List<Employee> exampleHiring() {
        Random r = new Random();
        hire("John", "Smith", 5, r.nextInt(50000, 100000));
        hire("Pamela", "Anderson", 5, r.nextInt(50000, 100000));
        hire("Tommy", "Lee", 5, r.nextInt(50000, 100000));
        hire("Till", "Shweiger", 5, r.nextInt(50000, 100000));
        hire("Ann", "Brown", 2, r.nextInt(50000, 100000));
        hire("Ron", "Grownship", 2, r.nextInt(50000, 100000));
        hire("James", "Alarmson", 2, r.nextInt(50000, 100000));
        return employeeList;

    }

    private boolean findEmployee(Employee employee) {
        boolean result = employeeList.contains(employee);
        return result;
    }

    public String welcome() {
        return "<h2> Course 2, Lesson 9: Stream and Optional<br><br>"

                + "Under construction, sorry</h2>";
        // !! make hint for /deparments/max-salary and other commands !!
    }

    public String maxSalary(int deptId) {
        return "deptId: " + Integer.valueOf(deptId).toString() + "<br>Sorry! maxSalary method is under construction";
    }

    public List<Employee> getDeptCrew(Integer dept) {
        if (dept == null) {
            return employeeList;
        }
        List<Employee> deptCrew = employeeList.stream().filter(employee -> employee.isDeptId(dept)).
                collect(Collectors.toList());
        return deptCrew;
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
