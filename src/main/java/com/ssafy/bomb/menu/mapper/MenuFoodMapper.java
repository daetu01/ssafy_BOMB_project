package com.ssafy.bomb.menu.mapper;

import com.ssafy.bomb.menu.dto.MenuFoodDTO;
import com.ssafy.bomb.menu.entity.MenuFood;
import org.springframework.stereotype.Component;

@Component
public class MenuFoodMapper {

    public static MenuFoodDTO.Get EntityToGet(MenuFood menufood) {
        return MenuFoodDTO.Get.builder()
                .id(menufood.getId())
                .food(menufood.getFood().getName())
                .menu(menufood.getMenu().getName())
                .amount(menufood.getAmount())
                .orderNo(menufood.getOrderNo())
                .registerDate(menufood.getRegisterDate())
                .build();
    }
}
