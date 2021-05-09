package ChaTho.hrms.business.concretes;

import ChaTho.hrms.business.abstracts.FreelancerService;
import ChaTho.hrms.dataAccess.abstracts.FreelancerDao;
import ChaTho.hrms.entities.concretes.Freelancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreelancerManager implements FreelancerService {

    private FreelancerDao freelancerDao;

    @Autowired
    public FreelancerManager(FreelancerDao freelancerDao) {
        super();
        this.freelancerDao = freelancerDao;
    }

    @Override
    public List<Freelancer> getAll() {
        return this.freelancerDao.findAll();
    }
}
