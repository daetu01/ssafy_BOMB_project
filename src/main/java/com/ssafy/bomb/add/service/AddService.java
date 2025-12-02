package com.ssafy.bomb.add.service;

import com.ssafy.bomb.add.dto.AddDTO;
import com.ssafy.bomb.add.entity.Add;
import com.ssafy.bomb.add.mapper.AddMapper;
import com.ssafy.bomb.add.repository.AddRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class AddService {

    private final AddMapper addMapper;
    private final AddRepository addRepository;

    @Transactional
    public AddDTO.Get save(AddDTO.Post post, String imageUrl) {
        Add add = addMapper.PostToEntity(post);

        return addMapper.EntityToGet(addRepository.save(add));
    }

    @Transactional
    public String saveImage(MultipartFile imageFile) throws IOException {
        if (imageFile == null || imageFile.isEmpty()) {
            return null;
        }

        String uploadDir = "src/main/resources/static/uploads/";
        String originalFilename = imageFile.getOriginalFilename();
        String fileName = URLEncoder.encode(System.currentTimeMillis() + "_" + originalFilename, StandardCharsets.UTF_8);
        Path filePath = Paths.get(uploadDir, fileName);

        if (!Files.exists(filePath.getParent())) {
            Files.createDirectories(filePath.getParent());
        }

        Files.write(filePath, imageFile.getBytes());

        return "/uploads/" + fileName;
    }
}
