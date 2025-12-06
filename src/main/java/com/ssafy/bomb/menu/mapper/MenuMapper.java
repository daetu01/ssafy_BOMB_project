package com.ssafy.bomb.menu.mapper;


import com.ssafy.bomb.menu.dto.MenuDTO;
import com.ssafy.bomb.menu.entity.Menu;
import org.springframework.stereotype.Component;

@Component
public class MenuMapper {

    public static Menu PostToEntity(MenuDTO.Post post) {
        return Menu.builder()
                .name(post.getName())
                .build();
    }

    public static MenuDTO.Get EntityToGet(Menu menu) {
        return MenuDTO.Get.builder()
                .id(menu.getId())
                .name(menu.getName())
                .build();
    }
}
