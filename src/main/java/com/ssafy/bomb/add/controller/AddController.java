package com.ssafy.bomb.add.controller;

import com.ssafy.bomb.add.dto.AddDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api/add/")
@RestController
@AllArgsConstructor
public class AddController {
    // CRUD

    public ResponseEntity<AddDTO.Get> postAdd (
            @ModelAttribute AddDTO.Post post,
            @RequestParam(required = false)MultipartFile imageFile
            ) {
        try {
            String imageUrl = null;

            if (imageFile != null && !imageFile.isEmpty()) {
                //
            }
        }
    }
}
