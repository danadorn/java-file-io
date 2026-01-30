package file_io;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class FileService {

    public Map<String, String> uploadSingleFile(File file) {

        try {
            // image.png
            int dotSymbolLocation = file.getName().lastIndexOf(".");
            String extension = file.getName().substring(dotSymbolLocation + 1);

            String newFileName = UUID.randomUUID() + "." + extension;
            String oldFileName = file.getAbsoluteFile().toString();

            // upload file to server
            String serverLocation = "media/";
            Files.copy(
                    Path.of(oldFileName),
                    new FileOutputStream(serverLocation + newFileName)
            );

            return Map.of(
                    "previewLink", "http://localhost:8080/media/" + newFileName,
                    "downloadLink", "http://localhost:8080/api/v1/media/download/" + newFileName
            );

        } catch (Exception exception) {
            System.out.println("Error during upload file 😥 " + exception.getMessage());
        }

        return null;
    }
    public List<Map<String,String>> multiplesUpload(File[] files){
        List<Map<String,String>> results = new ArrayList<>();
        for(File file: files){
            results.add(uploadSingleFile(file));
        }
        return results;
}
}
