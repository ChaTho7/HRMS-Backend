package ChaTho.hrms.api.controllers;

import ChaTho.hrms.business.abstracts.FreelancerService;
import ChaTho.hrms.core.utilities.results.Result;
import ChaTho.hrms.entities.concretes.Freelancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
    public Result<List<Freelancer>> getAll(){
        return this.freelancerService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public Result<Optional<Freelancer>> getById(@PathVariable Integer id){
        return this.freelancerService.getById(id);
    }

}
