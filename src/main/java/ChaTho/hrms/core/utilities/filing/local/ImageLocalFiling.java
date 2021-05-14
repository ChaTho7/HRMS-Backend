package ChaTho.hrms.core.utilities.filing.local;

import ChaTho.hrms.core.abstracts.File;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class ImageLocalFiling extends LocalFilingBase {
    private static String path = "C:\\Users\\Windows 8\\Desktop\\ChaTho The Programmer\\test\\java web api\\";

    @Override
    public String getPath() {
        return path;
    }

    @SneakyThrows
    @Override
    public void filing(File file, String uuid) {
        try {
            byte[] fileBytes = file.getFile().getBytes();
            String orgFileName = file.getFile().getOriginalFilename();
            String fileExtension = orgFileName.substring(orgFileName.lastIndexOf(".")+1);
            String newFileName = uuid + "." + fileExtension;
            String filePath = path + newFileName;

            Files.write(Paths.get(filePath), fileBytes);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }


    }
}
