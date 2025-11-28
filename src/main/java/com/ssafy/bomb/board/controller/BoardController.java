package com.ssafy.bomb.board.controller;

import com.ssafy.bomb.board.dto.BoardDTO;
import com.ssafy.bomb.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    // 게시글 작성 처리 (웹 요청, 폼 전송)
    @PostMapping("/create")
    public ResponseEntity<BoardDTO.Get> postBoard (
            @ModelAttribute BoardDTO.Post post,
            @RequestParam(required = false)MultipartFile imageFile
            ) {
        try {
            String imageUrl = null;
            if (imageFile != null && !imageFile.isEmpty()) {
                imageUrl = boardService.saveImage(imageFile);
            }

            BoardDTO.Get board = boardService.save(post, imageUrl);
            Long boardId = board.getId();

            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .location(URI.create("/board/" + boardId))
                    .build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

}
