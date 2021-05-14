package ChaTho.hrms.api.controllers;

import ChaTho.hrms.business.abstracts.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
    public ResponseEntity getAll() {
        var result = this.employerService.getAll();
        if (result.isSuccess()) {
            return new ResponseEntity(result, HttpStatus.OK);
        }
        return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
    }
}
