package com.ssafy.bomb.menu.dto;

import com.ssafy.bomb.menu.entity.Food;
import com.ssafy.bomb.menu.entity.Menu;
import lombok.*;

import java.time.LocalDate;

public class MenuFoodDTO {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Get {
        Long id ;
        String menu;
        String food;
        Integer orderNo;
        Integer amount;
        LocalDate registerDate;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter @Setter
    public static class Post {
        String menu;
        String food;
        Integer orderNo;
        Integer amount;
    }

}
