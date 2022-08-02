package com.example.trackwebserver.controller;

//import org.apache.commons.io.IOUtils;

import com.example.trackwebserver.service.TrackWebServerService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.activation.FileTypeMap;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

@RestController
public class TrackWebServerController {

    @Autowired
    private TrackWebServerService trackWebServerService;

    @GetMapping(value="/img/{name}",produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getImage(@PathVariable String name) throws IOException {
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(new InputStreamResource(trackWebServerService.getImage(name).getInputStream()));
    }

    @GetMapping(value="/ping")
    public ResponseEntity<String> pingForFile(){
        boolean exists = trackWebServerService.pingForFile();
        if(exists){
            return ResponseEntity.ok("OK");
        } else{
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("File is not present");
        }

    }




}
