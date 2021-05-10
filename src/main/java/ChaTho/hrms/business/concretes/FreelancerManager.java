package ChaTho.hrms.business.concretes;

import ChaTho.hrms.business.abstracts.FreelancerService;
import ChaTho.hrms.business.consts.Messages;
import ChaTho.hrms.core.utilities.businessRules.BusinessRules;
import ChaTho.hrms.core.utilities.results.FailResult;
import ChaTho.hrms.core.utilities.results.Result;
import ChaTho.hrms.core.utilities.results.SuccessResult;
import ChaTho.hrms.dataAccess.abstracts.FreelancerDao;
import ChaTho.hrms.entities.concretes.Freelancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FreelancerManager implements FreelancerService {

    private final FreelancerDao freelancerDao;

    @Autowired
    public FreelancerManager(FreelancerDao freelancerDao) {
        super();
        this.freelancerDao = freelancerDao;
    }

    @Override
    public Result<Freelancer> add(Freelancer freelancer) {
        var result= BusinessRules.ruleChecker(duplicateNameChecker(freelancer.getName()));

        if (result!=null){
            for (var error:result) {
                return new FailResult<Freelancer>(error.getMessage());
            }
        }

        this.freelancerDao.save(freelancer);
        return new SuccessResult<Freelancer>(Messages.addedData);
    }

    @Override
    public Result<Freelancer> delete(Freelancer freelancer) {
        this.freelancerDao.delete(freelancer);
        return new SuccessResult<Freelancer>(Messages.deletedData);
    }

    @Override
    public Result<Freelancer> update(Freelancer freelancer) {
        this.freelancerDao.save(freelancer);
        return new SuccessResult<Freelancer>(Messages.updatedData);
    }

    @Override
    public Result<Optional<Freelancer>> getById(Integer id) {
        return new SuccessResult<Optional<Freelancer>>(this.freelancerDao.findById(id),Messages.fetcedData);
    }

    @Override
    public Result<List<Freelancer>> getAll() {
        var result= BusinessRules.ruleChecker(dateTimeChecker());

        if (result!=null){
            for (var error:result) {
                return new FailResult<List<Freelancer>>(error.getMessage());
            }
        }

        return new SuccessResult<List<Freelancer>>(this.freelancerDao.findAll(),Messages.fetcedDataList);
    }

    private Result<Freelancer> duplicateNameChecker(String name){
        var result=this.freelancerDao.findAll().stream().anyMatch(t-> t.getName().equals(name));
        if (result){
            return new FailResult<Freelancer>(Messages.duplicateName);
        }
        return new SuccessResult<Freelancer>(Messages.success);
    }

    private Result<Freelancer> dateTimeChecker(){
        if(LocalDateTime.now().getHour()==19){
            return new FailResult<Freelancer>("Date");
        }else {
            return new SuccessResult<Freelancer>(Messages.success);
        }
    }
}
