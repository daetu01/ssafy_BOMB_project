package com.ssafy.bomb.board.dto;

import lombok.*;

import java.time.LocalDateTime;

public class BoardDTO {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Post {
        String title;
        String content;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Get {
        Long id ;
        String title ;
//        String userId;
        String content ;
        Integer viewCount;
        LocalDateTime createdDate;
        String imageUrl ;
    }
}
