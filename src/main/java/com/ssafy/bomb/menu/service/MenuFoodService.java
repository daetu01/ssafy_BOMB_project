package com.ssafy.bomb.menu.service;

import com.ssafy.bomb.menu.dto.MenuFoodDTO;
import com.ssafy.bomb.menu.entity.Food;
import com.ssafy.bomb.menu.entity.MenuFood;
import com.ssafy.bomb.menu.entity.Menu;
import com.ssafy.bomb.menu.mapper.MenuFoodMapper;
import com.ssafy.bomb.menu.repository.FoodRepository;
import com.ssafy.bomb.menu.repository.MenuFoodRepository;
import com.ssafy.bomb.menu.repository.MenuRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuFoodService {
    private final MenuFoodRepository menuFoodRepository;
    private final MenuRepository menuRepository;
    private final FoodRepository foodRepository;
    private final MenuFoodMapper menuFoodMapper;

    @Transactional
    public MenuFoodDTO.Get save(MenuFoodDTO.Post post) {
        System.out.println(post.getMenu());
        System.out.println(post.getFood());
        // menu 이름 찾아서 번호로 넣어야됨.
        Menu menu = menuRepository.findByName(post.getMenu())
                .orElseThrow(() -> new RuntimeException("Menu not Found"));
        // food 이름 찾아서 번호로 넣어야됨.
        Food food = foodRepository.findByName(post.getFood())
                .orElseThrow(() -> new RuntimeException("Food not Found"));

        MenuFood menuFood = MenuFood.builder()
                .menu(menu)
                .food(food)
                .orderNo(post.getOrderNo())
                .amount(post.getAmount())
                .build();

        return menuFoodMapper.EntityToGet(menuFoodRepository.save(menuFood)) ;
    }

    @Transactional
    public List<MenuFoodDTO.Get> getAllMenuFoods() {
        List<MenuFood> menufoodList = menuFoodRepository.findAll();

        List<MenuFoodDTO.Get> rec = new ArrayList<>();

        for (MenuFood menufood : menufoodList) {
            rec.add(menuFoodMapper.EntityToGet(menufood));
        }

        return rec;
    }
}
