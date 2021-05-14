package ChaTho.hrms.business.concretes;

import ChaTho.hrms.business.abstracts.JobPositionService;
import ChaTho.hrms.business.consts.Messages;
import ChaTho.hrms.core.utilities.businessRules.BusinessRules;
import ChaTho.hrms.core.utilities.results.FailResult;
import ChaTho.hrms.core.utilities.results.Result;
import ChaTho.hrms.core.utilities.results.SuccessResult;
import ChaTho.hrms.dataAccess.abstracts.JobPositionDao;
import ChaTho.hrms.entities.concretes.JobPositon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        super();
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public Result<JobPositon> add(JobPositon jobPositon) {
        var result =
                BusinessRules.ruleChecker(
                        duplicateNameChecker(jobPositon.getName())
                );

        if (result != null) {
            for (var error : result) {
                return new FailResult<JobPositon>(error.getMessage());
            }
        }

        this.jobPositionDao.save(jobPositon);
        return new SuccessResult<JobPositon>(Messages.addedData);
    }

    @Override
    public Result<JobPositon> delete(JobPositon jobPositon) {
        this.jobPositionDao.delete(jobPositon);
        return new SuccessResult<JobPositon>(Messages.deletedData);
    }

    @Override
    public Result<JobPositon> update(JobPositon jobPositon) {
        this.jobPositionDao.save(jobPositon);
        return new SuccessResult<JobPositon>(Messages.updatedData);
    }

    @Override
    public Result<List<JobPositon>> getAll() {
        return new SuccessResult<List<JobPositon>>(this.jobPositionDao.findAll(), Messages.fetcedDataList);
    }

    @Override
    public Result<JobPositon> getById(Integer id) {
        return new SuccessResult<JobPositon>(this.jobPositionDao.getOne(id), Messages.fetcedData);
    }

    private Result<JobPositon> duplicateNameChecker(String name) {
        var result = this.jobPositionDao.findAll().stream().anyMatch(t -> t.getName().equals(name));
        if (result) {
            return new FailResult<JobPositon>(Messages.duplicateEmail);
        }
        return new SuccessResult<JobPositon>(Messages.success);
    }
}
