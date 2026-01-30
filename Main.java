package file_io;

import file_io.FileService;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        FileService fileService = new FileService();
        File file = new File("/home/dorndana/Pictures/1.png");
        File fileq1 = new File("/home/dorndana/Pictures/2.png");
        Object result = fileService.uploadSingleFile(file);
        System.out.println(result);
    }
}
