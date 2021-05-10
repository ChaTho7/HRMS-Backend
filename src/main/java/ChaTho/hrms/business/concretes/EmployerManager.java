package ChaTho.hrms.business.concretes;

import ChaTho.hrms.business.abstracts.EmployerService;
import ChaTho.hrms.business.consts.Messages;
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
        return new SuccessResult<List<Employer>>(this.employerDao.findAll(),Messages.fetcedDataList);
    }

    @Override
    public Result<Employer> getById(Integer id) {
        return new SuccessResult<Employer>(this.employerDao.getOne(id), Messages.fetcedData);
    }
}
