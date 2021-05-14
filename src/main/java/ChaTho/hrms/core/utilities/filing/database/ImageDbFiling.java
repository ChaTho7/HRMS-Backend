package ChaTho.hrms.core.utilities.filing.database;

import ChaTho.hrms.core.abstracts.File;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

@Component
public class ImageDbFiling extends DatabaseFilingBase {
    @SneakyThrows
    @Override
    public byte[] fileToBytes(File imageFile) {
        try {
            return Base64Utils.encode(imageFile.getFile().getBytes());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
