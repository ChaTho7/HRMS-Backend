package ChaTho.hrms.business.abstracts;

import ChaTho.hrms.core.utilities.results.Result;
import ChaTho.hrms.entities.concretes.FreelancerPicture;
import ChaTho.hrms.core.concretes.files.Image;

public interface FreelancerPictureService {
    Result<FreelancerPicture> add(Image image, Integer freelancerId);
    Result<FreelancerPicture> delete(FreelancerPicture picture);
    Result<FreelancerPicture> update(Image image, Integer freelancerId);
    Result<FreelancerPicture> getById(Integer freelancerId);
}
