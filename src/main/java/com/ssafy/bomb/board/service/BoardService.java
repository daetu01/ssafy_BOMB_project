package com.ssafy.bomb.board.service;

import com.ssafy.bomb.board.dto.BoardDTO;
import com.ssafy.bomb.board.entity.Board;
import com.ssafy.bomb.board.mapper.BoardMapper;
import com.ssafy.bomb.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    @Transactional
    public BoardDTO.Get save(BoardDTO.Post post, String imageUrl) {
        Board board = Board.builder()
                .title(post.getTitle())
                .content(post.getContent().replace("\n", "<br>")) // 줄바꿈 적용

                .imageUrl(imageUrl) // 이미지 URL 설정
                .build();
        // Board board = BoardMapper.PostToEntity(post, user, imageUrl);
        return boardMapper.EntityToGET(boardRepository.save(board));
    }

    // 이미지 저장 처리
    public String saveImage(MultipartFile imageFile) throws IOException {
        if (imageFile == null || imageFile.isEmpty()) {
            return null; // 이미지가 없는 경우
        }

        // 실제 파일 저장 경로
        String uploadDir = "src/main/resources/static/uploads/";
        String originalFilename = imageFile.getOriginalFilename();
        String fileName = URLEncoder.encode(System.currentTimeMillis() + "_" + originalFilename, StandardCharsets.UTF_8);
        Path filePath = Paths.get(uploadDir, fileName);

        // 디렉토리가 없으면 생성
        if (!Files.exists(filePath.getParent())) {
            Files.createDirectories(filePath.getParent());
        }

        Files.write(filePath, imageFile.getBytes());

        // 클라이언트에서 접근 가능한 URL 반환
        return "/uploads/" + fileName;
    }

}
