package com.halemia.familymanager.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @Author : shangchy
 * @Date : Create in 14:42 2024/2/7
 */

@RestController
@RequestMapping("/rest/api")
public class ImageController {

    private static final String UPLOAD_PATH = "src/main/resources/static/image";


    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public ResponseEntity<byte[]> insert(@RequestParam String imageName) throws IOException {
        ClassPathResource imgFile = new ClassPathResource("static/image/" + imageName);

        if (!imgFile.exists()) {
            return ResponseEntity.notFound().build();
        }

        byte[] imageBytes = Files.readAllBytes(imgFile.getFile().toPath());

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a file to upload");
        }
        try {
            // Get the file name and save it to the upload directory
            String fileName = file.getOriginalFilename();
            File dest = new File(new File(UPLOAD_PATH).getAbsolutePath(), fileName);
            file.transferTo(dest);

            return ResponseEntity.status(HttpStatus.CREATED).body("File uploaded successfully: " + fileName);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }
    }

}
