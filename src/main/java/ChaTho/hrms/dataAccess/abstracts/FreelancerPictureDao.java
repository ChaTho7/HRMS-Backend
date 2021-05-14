package ChaTho.hrms.dataAccess.abstracts;

import ChaTho.hrms.entities.concretes.FreelancerPicture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreelancerPictureDao extends JpaRepository<FreelancerPicture, Integer> {
}
