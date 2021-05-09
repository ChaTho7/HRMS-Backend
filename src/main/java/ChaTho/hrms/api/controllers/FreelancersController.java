package ChaTho.hrms.api.controllers;

import ChaTho.hrms.business.abstracts.FreelancerService;
import ChaTho.hrms.entities.concretes.Freelancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<Freelancer> getAll(){
        return this.freelancerService.getAll();
    }
}
