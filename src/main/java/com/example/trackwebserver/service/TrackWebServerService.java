package com.example.trackwebserver.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Service
public class TrackWebServerService {


    public ClassPathResource getImage(String name) throws IOException {
        ClassPathResource imgFile = new ClassPathResource("static/images/BeastBoy.gif");
        String filePath = "static/files/tmp/ok.txt";
        if(Files.notExists(Path.of(filePath))) {
            Path pathToFile = Paths.get(filePath);
            Files.createDirectories(pathToFile.getParent());
            Files.createFile(pathToFile);
        }
         try(FileWriter fw = new FileWriter(filePath, true);
             BufferedWriter writer = new BufferedWriter(fw);) {
            writer.write(name+"\t"+new Date());
             writer.write("\n\n");
        } catch (Exception ex){
             System.out.println(ex.getLocalizedMessage());
         }
        return imgFile;
    }

    public boolean pingForFile() {

            String filePath = "static/files/tmp/ok.txt";
            File tempFile = new File(filePath);
           return  tempFile.exists();



    }
}
