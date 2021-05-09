package ChaTho.hrms.dataAccess.abstracts;

import ChaTho.hrms.entities.concretes.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreelancerDao extends JpaRepository<Freelancer,Integer> {

}
