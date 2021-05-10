package ChaTho.hrms.api.controllers;

import ChaTho.hrms.business.abstracts.JobPositionService;
import ChaTho.hrms.core.utilities.results.Result;
import ChaTho.hrms.entities.concretes.JobPositon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {

    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        super();
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getall")
    public Result<List<JobPositon>> getAll(){
        return this.jobPositionService.getAll();
    }
}
