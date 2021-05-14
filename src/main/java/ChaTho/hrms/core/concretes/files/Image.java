package ChaTho.hrms.core.concretes.files;

import ChaTho.hrms.core.abstracts.File;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class Image implements File {
    private MultipartFile file;

    public Image(){}

    public Image(MultipartFile file) {
        this.file = file;
    }
}
