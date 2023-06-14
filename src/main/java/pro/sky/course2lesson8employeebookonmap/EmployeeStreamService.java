package pro.sky.course2lesson8employeebookonmap;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class EmployeeStreamService {

    private int maxPersonnelNumber = 100;

    private int personnelCount = 0;

    private final List<Employee> employeeList = new ArrayList<>();

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

    public Employee hire(String firstName, String lastName, int deptId, int salary) {

        NameCheck nameCheck = new NameCheck(firstName, lastName);

        if (!nameCheck.isOk()) {
            throw new WrongNameFormatException();
        }

        if (personnelCount >= maxPersonnelNumber) {
            throw new EmployeeStorageIsFullException();
        } else {
            personnelCount++;
        }

        Employee employee = new Employee(firstName, lastName, Status.hired, deptId, salary);

        if (isHired(employee)) {
            throw new EmployeeAlreadyAddedException();
        }

        boolean add = employeeList.add(employee);

        Employee e = employeeList.get(personnelCount - 1);

        return e;
    }

    public List<Employee> exampleHiring() {
        Random r = new Random();
        hire("John", "Smith", 5, r.nextInt(50000, 100000));

        hire("Till", "Shweiger", 5, r.nextInt(50000, 100000));
        hire("Ann", "Brown", 2, r.nextInt(50000, 100000));
        hire("Ron", "Grownship", 2, r.nextInt(50000, 100000));
        hire("James", "Alarmson", 2, r.nextInt(50000, 100000));
        hire("Pamela", "Anderson", 5, r.nextInt(50000, 100000));
        hire("Tommy", "Lee", 5, r.nextInt(50000, 100000));
        return employeeList;

    }

    private boolean isHired(Employee employee) {
        return employeeList.contains(employee);
    }

    public String welcome() {
        return "<h2> Course 2, Lesson 9: Stream and Optional<br><br></h2><br><br>" +
                "<b>Check Names With StringUtils methods</b>"
                + "<br><br><a href=\"http://localhost:8080/departments/\"> Departments </a><br><br>" +
                "<a href=\"http://localhost:8080/departments/example-hire/\"> Hire example persons </a><br>" +
                "<a href=\"http://localhost:8080/departments/max-salary?departmentId=2\"> Max Salary in Department No.2 </a> |" +
                "<a href=\"http://localhost:8080/departments/max-salary?departmentId=5\"> Max Salary in Department No.5</a> |" +
                "<a href=\"http://localhost:8080/departments/max-salary\"> Max Salary in Company </a><br>" +
                "<a href=\"http://localhost:8080/departments/min-salary?departmentId=2\"> Min Salary in Department No.2 </a> |" +
                "<a href=\"http://localhost:8080/departments/min-salary?departmentId=5\"> Min Salary in Department No.5 </a> |" +
                "<a href=\"http://localhost:8080/departments/min-salary\"> Min Salary in Company </a><br>" +
                "<a href=\"http://localhost:8080/departments/all\"> Company crew sorted by department </a> |" +
                "<a href=\"http://localhost:8080/departments/all?departmentId=2\"> Department No.2 crew </a> |" +
                "<a href=\"http://localhost:8080/departments/all?departmentId=5\"> Department No.5 crew </a>";
    }

    public String maxSalary(Integer deptId) {

        List<Employee> deptCrewResult = getDeptCrew(deptId);
        if (deptCrewResult == null) {
            return "no personnel hired";
        }

        deptCrewResult.sort(Comparator.comparingInt(employee -> employee.getSalary()));
        return deptCrewResult.get(deptCrewResult.size() - 1) + "<br><br>" + deptCrewResult;
    }

    public String minSalary(Integer deptId) {

        List<Employee> deptCrewResult = getDeptCrew(deptId);

        if (deptCrewResult == null) {
            return "no personnel hired";
        }
        deptCrewResult.sort(Comparator.comparingInt(employee -> employee.getSalary()));
        return deptCrewResult.get(0) + "<br><br>" + deptCrewResult;

    }

    public List<Employee> getDeptCrew(Integer dept) {

        if (dept == null) {
            List<Employee> crewSortedByDept;
            crewSortedByDept = employeeList.stream().sorted().collect(Collectors.toList());
            return crewSortedByDept;
        }
        List<Employee> deptCrew = employeeList.stream().filter(employee -> employee.isDeptId(dept)).
                collect(Collectors.toList());
        return deptCrew;
    }

    public String checkNames(String firstName, String lastName) {
        NameCheck nameCheck = new NameCheck(firstName, lastName);
        return "<h2>checkNames method is under construction </h2><br><br>" +
                "firstName: " + firstName + "<br><br> lastName: " + lastName + "<br><br>" + nameCheck.getMessage();
    }

}
