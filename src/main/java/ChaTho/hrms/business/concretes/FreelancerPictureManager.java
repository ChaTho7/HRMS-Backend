package ChaTho.hrms.business.concretes;

import ChaTho.hrms.business.abstracts.FreelancerPictureService;
import ChaTho.hrms.business.consts.Messages;
import ChaTho.hrms.core.utilities.businessRules.BusinessRules;
import ChaTho.hrms.core.utilities.filing.database.DatabaseFilingBase;
import ChaTho.hrms.core.utilities.filing.local.LocalFilingBase;
import ChaTho.hrms.core.utilities.results.FailResult;
import ChaTho.hrms.core.utilities.results.Result;
import ChaTho.hrms.core.utilities.results.SuccessResult;
import ChaTho.hrms.core.utilities.uuid.UuidGenerator;
import ChaTho.hrms.dataAccess.abstracts.FreelancerPictureDao;
import ChaTho.hrms.entities.concretes.FreelancerPicture;
import ChaTho.hrms.core.concretes.files.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FreelancerPictureManager implements FreelancerPictureService {

    private FreelancerPictureDao freelancerPictureDao;
    private DatabaseFilingBase databaseFilingBase;
    private LocalFilingBase localFilingBase;

    @Autowired
    public FreelancerPictureManager(FreelancerPictureDao freelancerPictureDao, DatabaseFilingBase databaseFilingBase, LocalFilingBase localFilingBase) {
        super();
        this.freelancerPictureDao = freelancerPictureDao;
        this.databaseFilingBase = databaseFilingBase;
        this.localFilingBase = localFilingBase;
    }


    @Override
    public Result<FreelancerPicture> add(Image image, Integer freelancerId) {
        var result =
                BusinessRules.ruleChecker();

        if (result != null) {
            for (var error : result) {
                return new FailResult<FreelancerPicture>(error.getMessage());
            }
        }

        byte[] pictureArray = databaseFilingBase.fileToBytes(image);

        FreelancerPicture freelancerPicture = new FreelancerPicture(
                freelancerId, "123", LocalDate.now(), pictureArray, UuidGenerator.generateUuid()
        );

        this.localFilingBase.filing(image,freelancerPicture.getUuid());
        //this.freelancerPictureDao.save(freelancerPicture);
        return new SuccessResult<FreelancerPicture>(Messages.addedData);
    }

    @Override
    public Result<FreelancerPicture> delete(FreelancerPicture picture) {
        return null;
    }

    @Override
    public Result<FreelancerPicture> update(Image image, Integer freelancerId) {
        return null;
    }

    @Override
    public Result<FreelancerPicture> getById(Integer freelancerId) {
        var result =
                BusinessRules.ruleChecker();

        if (result != null) {
            for (var error : result) {
                return new FailResult<FreelancerPicture>(error.getMessage());
            }
        }

        return new SuccessResult<FreelancerPicture>(this.freelancerPictureDao.findAll().stream().filter(p->p.getFreelancerId()==freelancerId).findFirst().get(), Messages.addedData);
    }
}
