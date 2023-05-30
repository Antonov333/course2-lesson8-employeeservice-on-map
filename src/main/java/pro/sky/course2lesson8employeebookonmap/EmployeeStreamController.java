package pro.sky.course2lesson8employeebookonmap;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class EmployeeStreamController {

    EmployeeStreamService employeeService = new EmployeeStreamService();

    @GetMapping()
    public String welcome() {
        return employeeService.welcome();
    }

}
