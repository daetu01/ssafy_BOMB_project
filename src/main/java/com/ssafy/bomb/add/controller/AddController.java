package com.ssafy.bomb.add.controller;

import ch.qos.logback.core.status.Status;
import com.ssafy.bomb.add.dto.AddDTO;
import com.ssafy.bomb.add.service.AddService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api/add/")
@RestController
@AllArgsConstructor
public class AddController {
    // CRUD
    private final AddService addService;

    @PostMapping("create/")
    public ResponseEntity<AddDTO.Get> postAdd (
            @ModelAttribute AddDTO.Post post,
            @RequestParam(required = false)MultipartFile imageFile
            ) {
        try {
            String imageUrl = null;

            if (imageFile != null && !imageFile.isEmpty()) {
                imageUrl = addService.saveImage(imageFile);
            }

            return ResponseEntity.ok(addService.save(post, imageUrl));
        } catch (Exception e ) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
