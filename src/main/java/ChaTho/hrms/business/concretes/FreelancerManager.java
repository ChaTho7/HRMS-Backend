package ChaTho.hrms.business.concretes;

import ChaTho.hrms.business.abstracts.FreelancerService;
import ChaTho.hrms.business.consts.Messages;
import ChaTho.hrms.business.microServices.mernis.IVQKPSPublicSoap12;
import ChaTho.hrms.core.utilities.businessRules.BusinessRules;
import ChaTho.hrms.core.utilities.regexes.Regex;
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

    private FreelancerDao freelancerDao;

    @Autowired
    public FreelancerManager(FreelancerDao freelancerDao) {
        super();
        this.freelancerDao = freelancerDao;
    }

    @Override
    public Result<Freelancer> add(Freelancer freelancer) throws Exception {
        var result =
                BusinessRules.ruleChecker(
                        mernisValidation(freelancer),
                        duplicateEmailChecker(freelancer.getEmail()),
                        emailRegexChecker(freelancer.getEmail()),
                        duplicateNationalityIdChecker(freelancer.getNationalityId())
                );

        if (result != null) {
            for (var error : result) {
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
    public Result<Freelancer> getById(Integer id) {
        return new SuccessResult<Freelancer>(this.freelancerDao.findById(id).get(), Messages.fetcedData);
    }

    @Override
    public Result<List<Freelancer>> getAll() {
        var result = BusinessRules.ruleChecker(dateTimeChecker());

        if (result != null) {
            for (var error : result) {
                return new FailResult<List<Freelancer>>(error.getMessage());
            }
        }

        return new SuccessResult<List<Freelancer>>(this.freelancerDao.findAll(), Messages.fetcedDataList);
    }

    private Result<Freelancer> emailRegexChecker(String email) {
        var result = Regex.validate(email);
        if (result) {
            return new SuccessResult<Freelancer>(Messages.success);
        }
        return new FailResult<Freelancer>(Messages.regexFailEmail);
    }

    private Result<Freelancer> duplicateEmailChecker(String email) {
        var result = this.freelancerDao.findAll().stream().anyMatch(t -> t.getEmail().equals(email));
        if (result) {
            return new FailResult<Freelancer>(Messages.duplicateEmail);
        }
        return new SuccessResult<Freelancer>(Messages.success);
    }

    private Result<Freelancer> duplicateNationalityIdChecker(String nationalityId) {
        var result = this.freelancerDao.findAll().stream().anyMatch(t -> t.getNationalityId().equals(nationalityId));
        if (result) {
            return new FailResult<Freelancer>(Messages.duplicateNationalityId);
        }
        return new SuccessResult<Freelancer>(Messages.success);
    }

    private Result<Freelancer> dateTimeChecker() {
        if (LocalDateTime.now().getHour() == 19) {
            return new FailResult<Freelancer>("Date");
        } else {
            return new SuccessResult<Freelancer>(Messages.success);
        }
    }

    private Result<Freelancer> mernisValidation(Freelancer freelancer) throws Exception {
        var result = new IVQKPSPublicSoap12().TCKimlikNoDogrula(Long.parseLong(freelancer.getNationalityId()),freelancer.getName(),freelancer.getSurname(),Integer.parseInt(freelancer.getBirthYear()));
        if (!result) {
            return new FailResult<Freelancer>(Messages.failMernisIdentity);
        }
        return new SuccessResult<Freelancer>(Messages.success);
    }
}
