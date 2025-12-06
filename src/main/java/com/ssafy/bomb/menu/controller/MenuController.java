package com.ssafy.bomb.menu.controller;

import com.ssafy.bomb.menu.dto.MenuDTO;
import com.ssafy.bomb.menu.dto.MenuFoodDTO;
import com.ssafy.bomb.menu.service.MenuFoodService;
import com.ssafy.bomb.menu.service.MenuService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


// 광고 불러오기
// 식단 확인
@RequestMapping("/api/menu/")
@RestController
@AllArgsConstructor
public class MenuController {

    private final MenuService menuService;


    @GetMapping("")
    public ResponseEntity<List<MenuDTO.Get>> getMenu() {
        // 메뉴 불러오기

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(menuService.getAllMenus());
    }

    @GetMapping("{id}/")
    public ResponseEntity<MenuDTO.Get> getMenu(@PathVariable Long id) {

        MenuDTO.Get menu = menuService.findById(id);
        return ResponseEntity.ok(menu);
    }

    @PostMapping("create/")
    public ResponseEntity<MenuDTO.Get> postMenu(
            @ModelAttribute MenuDTO.Post post
    ) {
        try {
            MenuDTO.Get menu = menuService.save(post);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(menu);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }

    }

    @DeleteMapping("{id}/")
    public ResponseEntity<HttpStatus> deleteMenu(
            @RequestParam Long id
    ) {
        try {
            menuService.delete(id);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT) // 204 삭제 성공 응답.
                    .build();
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @PutMapping("{id}/")
    public ResponseEntity<MenuDTO.Get> updateMenu(
            @ModelAttribute MenuDTO.Put put, @RequestParam Long id
    ) {

        MenuDTO.Get updated = menuService.update(id, put);
        return ResponseEntity.ok(updated);

    }
}
