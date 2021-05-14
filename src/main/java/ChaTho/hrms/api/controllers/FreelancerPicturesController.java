package ChaTho.hrms.api.controllers;

import ChaTho.hrms.business.abstracts.FreelancerPictureService;
import ChaTho.hrms.core.concretes.files.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/freelancerPictures")
public class FreelancerPicturesController {

    private FreelancerPictureService freelancerPictureService;

    @Autowired
    public FreelancerPicturesController(FreelancerPictureService freelancerPictureService) {
        super();
        this.freelancerPictureService = freelancerPictureService;
    }

    @GetMapping("getById")
    public ResponseEntity getPicture(String freelancerId){
        var result = this.freelancerPictureService.getById(Integer.valueOf(freelancerId));
        if (result.isSuccess()) {
            return new ResponseEntity(result, HttpStatus.OK);
        }
        return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("post")
    public ResponseEntity postPicture(@ModelAttribute MultipartFile file, String freelancerId) {
        Image image = new Image(file);
        var result = this.freelancerPictureService.add(image,Integer.valueOf(freelancerId));
        if (result.isSuccess()) {
            return new ResponseEntity(result, HttpStatus.OK);
        }
        return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
    }
}
