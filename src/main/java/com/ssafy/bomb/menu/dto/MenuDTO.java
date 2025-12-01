package com.ssafy.bomb.menu.dto;


import lombok.*;


public class MenuDTO {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Post {
        String name;
        int calorie;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Get {
        Long id ;
        String name ;
        int calorie;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Put {
        String name ;
        int calorie;
    }

}
