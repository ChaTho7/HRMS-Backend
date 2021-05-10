package ChaTho.hrms.api.controllers;

import ChaTho.hrms.business.abstracts.EmployerService;
import ChaTho.hrms.core.utilities.results.Result;
import ChaTho.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        super();
        this.employerService = employerService;
    }

    @GetMapping("/getall")
    public Result<List<Employer>> getAll(){
        return this.employerService.getAll();
    }
}
