package ChaTho.hrms.business.concretes;

import ChaTho.hrms.business.abstracts.EmployerService;
import ChaTho.hrms.business.consts.Messages;
import ChaTho.hrms.core.utilities.businessRules.BusinessRules;
import ChaTho.hrms.core.utilities.results.FailResult;
import ChaTho.hrms.core.utilities.results.Result;
import ChaTho.hrms.core.utilities.results.SuccessResult;
import ChaTho.hrms.dataAccess.abstracts.EmployerDao;
import ChaTho.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        super();
        this.employerDao = employerDao;
    }

    @Override
    public Result<Employer> add(Employer employer) {
        var result =
                BusinessRules.ruleChecker(
                        duplicateEmailChecker(employer.getEmail())
                );

        if (result != null) {
            for (var error : result) {
                return new FailResult<Employer>(error.getMessage());
            }
        }

        this.employerDao.save(employer);
        return new SuccessResult<Employer>(Messages.addedData);
    }

    @Override
    public Result<Employer> delete(Employer employer) {
        this.employerDao.delete(employer);
        return new SuccessResult<Employer>(Messages.deletedData);
    }

    @Override
    public Result<Employer> update(Employer employer) {
        this.employerDao.save(employer);
        return new SuccessResult<Employer>(Messages.updatedData);
    }

    @Override
    public Result<List<Employer>> getAll() {
        return new SuccessResult<List<Employer>>(this.employerDao.findAll(), Messages.fetcedDataList);
    }

    @Override
    public Result<Employer> getById(Integer id) {
        return new SuccessResult<Employer>(this.employerDao.getOne(id), Messages.fetcedData);
    }

    private Result<Employer> duplicateEmailChecker(String email) {
        var result = this.employerDao.findAll().stream().anyMatch(t -> t.getEmail().equals(email));
        if (result) {
            return new FailResult<Employer>(Messages.duplicateEmail);
        }
        return new SuccessResult<Employer>(Messages.success);
    }
}
