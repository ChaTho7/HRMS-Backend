package ChaTho.hrms.business.abstracts;

import ChaTho.hrms.core.utilities.results.Result;
import ChaTho.hrms.entities.concretes.JobPositon;

import java.util.List;

public interface JobPositionService {

    Result<JobPositon> add(JobPositon jobPositon);
    Result<JobPositon> delete(JobPositon jobPositon);
    Result<JobPositon> update(JobPositon jobPositon);
    Result<List<JobPositon>> getAll();
    Result<JobPositon> getById(Integer id);
}
