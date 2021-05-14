package ChaTho.hrms.api.controllers;

import ChaTho.hrms.business.abstracts.FreelancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/freelancers")
public class FreelancersController {

    private FreelancerService freelancerService;

    @Autowired
    public FreelancersController(FreelancerService freelancerService) {
        super();
        this.freelancerService = freelancerService;
    }

    @GetMapping("/getall")
    public ResponseEntity getAll() {
        var result = this.freelancerService.getAll();
        if (result.isSuccess()) {
            return new ResponseEntity(result, HttpStatus.OK);
        }
        return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        var result = this.freelancerService.getById(id);
        if (result.isSuccess()) {
            return new ResponseEntity(result, HttpStatus.OK);
        }
        return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
    }

}
