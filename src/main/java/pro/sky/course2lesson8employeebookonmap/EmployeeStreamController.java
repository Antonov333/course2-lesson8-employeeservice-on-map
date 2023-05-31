package pro.sky.course2lesson8employeebookonmap;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class EmployeeStreamController {

    EmployeeStreamService streamService = new EmployeeStreamService(3);


    @GetMapping()
    public String welcome() {
        return streamService.welcome();
    }

    @GetMapping(path = "/max-salary")
    public String maxSalary() {
        return streamService.maxSalary();
    }


}
