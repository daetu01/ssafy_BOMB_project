package com.ssafy.bomb.board.mapper;

import com.ssafy.bomb.board.dto.BoardDTO;
import com.ssafy.bomb.board.entity.Board;
import org.springframework.stereotype.Component;

@Component
// 추후에 MapStruct로 자동 매퍼로 변환.
public class BoardMapper {

    // 게시글 생성 요청 DTO를 엔티티로 변환
    public static Board PostToEntity(BoardDTO.Post post) {
        return Board.builder()
                .title(post.getTitle())
                .content(post.getContent() != null ? post.getContent().replaceAll("(\r\n|\r|\n)", "<br>") : "")
                .build();
    }

    // 엔티티를 조회 응답 DTO로 변환
    public static BoardDTO.Get EntityToGET(Board board) {
        return BoardDTO.Get.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .createdDate(board.getCreatedDate())
                .viewCount(board.getViewCount())
                .imageUrl(board.getImageUrl()) // 이미지 URL 추가
                .build();
    }
}