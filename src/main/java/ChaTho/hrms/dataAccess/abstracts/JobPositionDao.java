package ChaTho.hrms.dataAccess.abstracts;

import ChaTho.hrms.entities.concretes.JobPositon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionDao extends JpaRepository<JobPositon, Integer> {
}
