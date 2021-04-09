package com.firebasecrud.controllers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.firebasecrud.services.StorageService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class StorageController {
	
	@Autowired
	private StorageService service;
	
//	private static final Logger logger = LoggerFactory.getLogger(StorageController.class);

	@PostMapping("/profile/pic")
    public Object upload(@RequestParam("file") MultipartFile multipartFile) {
//        logger.info("HIT -/upload | File Name : {}", multipartFile.getOriginalFilename());
        return service.upload(multipartFile);
    }

    @PostMapping("/profile/pic/{fileName}")
    public Object download(@PathVariable String fileName) throws Exception {
//        logger.info("HIT -/download | File Name : {}", fileName);
        return service.download(fileName);
    }
    
    @PostMapping("/profile/pic/delete/{fileName}")
    public Object delete(@PathVariable String fileName) throws Exception {
//        logger.info("HIT -/delete | File Name : {}", fileName);
        return service.delete(fileName);
    }
}
