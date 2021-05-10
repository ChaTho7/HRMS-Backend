package ChaTho.hrms.business.abstracts;

import ChaTho.hrms.core.utilities.results.Result;
import ChaTho.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {

    Result<Employer> add(Employer employer);
    Result<Employer> delete(Employer employer);
    Result<Employer> update(Employer employer);
    Result<List<Employer>> getAll();
    Result<Employer> getById(Integer id);
}
