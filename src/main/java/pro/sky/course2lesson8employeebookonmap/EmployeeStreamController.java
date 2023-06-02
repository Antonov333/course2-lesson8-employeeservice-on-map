package pro.sky.course2lesson8employeebookonmap;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class EmployeeStreamController {

    EmployeeStreamService streamService = new EmployeeStreamService(15);

    @GetMapping()
    public String welcome() {
        return streamService.welcome();
    }

    @GetMapping(path = "/example-hire")
    public List<Employee> hire2dept5() {
        streamService.exampleHiring();
        return streamService.getEmployeeList();
    }

    @GetMapping(path = "/list")
    public List<Employee> list() {
        return streamService.getEmployeeList();
    }

    @GetMapping(path = "/max-salary")
    public String maxSalary() {
        return streamService.maxSalary(5);
    }

    @GetMapping(path = "/all")
    public List<Employee> showCrew(@RequestParam(required = false, name = "departmentId") Integer dept) {
        return streamService.getDeptCrew(dept);
    }

}
