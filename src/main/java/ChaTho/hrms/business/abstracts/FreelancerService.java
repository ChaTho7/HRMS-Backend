package ChaTho.hrms.business.abstracts;

import ChaTho.hrms.core.utilities.results.Result;
import ChaTho.hrms.entities.concretes.Freelancer;

import java.util.List;
import java.util.Optional;

public interface FreelancerService {
    Result<Freelancer> add(Freelancer freelancer) throws Exception;
    Result<Freelancer> delete(Freelancer freelancer);
    Result<Freelancer> update(Freelancer freelancer);
    Result<List<Freelancer>> getAll();
    Result<Freelancer> getById(Integer id);
}
