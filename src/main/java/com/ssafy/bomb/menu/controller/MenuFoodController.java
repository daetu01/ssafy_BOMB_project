package com.ssafy.bomb.menu.controller;

import com.ssafy.bomb.menu.dto.MenuFoodDTO;
import com.ssafy.bomb.menu.service.MenuFoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menufood")
@AllArgsConstructor
public class MenuFoodController {

    private final MenuFoodService menuFoodService;

    // Menu_Food에 추가하기.
    @PostMapping("/")
    public ResponseEntity<MenuFoodDTO.Get> postMenuFood(
            @ModelAttribute MenuFoodDTO.Post post
    ) {
        try {
            MenuFoodDTO.Get menufood = menuFoodService.save(post);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(menufood);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }


    @CrossOrigin(origins = "http://localhost:5173")
    // Menu_Food에서 불러오기
    @GetMapping("/")
    public ResponseEntity<List<MenuFoodDTO.Get>> getMenuFood(

    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(menuFoodService.getAllMenuFoods());
    }
}
