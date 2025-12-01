package com.ssafy.bomb.add.dto;

import lombok.*;

import java.time.LocalDateTime;

public class AddDTO {

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class Post {
        private String title ;
        private String href;
        private String imageUrl;
        private LocalDateTime startDate;
        private LocalDateTime endDate ;
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class Get {
        private Long id ;
        private String title ;
        private String href;
        private String imageUrl ;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
    }
}
