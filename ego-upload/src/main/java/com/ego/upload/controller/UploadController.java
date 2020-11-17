package com.ego.upload.controller;

import com.ego.upload.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 〈〉
 *
 * @author coach tam
 * @email 327395128@qq.com
 * @create 2019/5/29
 * @since 1.0.0
 * 〈坚持灵活 灵活坚持〉
 */
@RestController
@RequestMapping("/upload/image")
public class UploadController {
    @Autowired
    private UploadService uploadService;
    @PostMapping
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file)
    {
        String imageUrl =uploadService.upload(file);
        if(imageUrl==null)
        {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(imageUrl);
    }
}
