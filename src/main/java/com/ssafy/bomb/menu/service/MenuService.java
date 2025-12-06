package com.ssafy.bomb.menu.service;

import com.ssafy.bomb.menu.dto.MenuDTO;
import com.ssafy.bomb.menu.entity.Menu;
import com.ssafy.bomb.menu.mapper.MenuMapper;
import com.ssafy.bomb.menu.repository.MenuRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;
    private final MenuMapper menuMapper;

    @Transactional
    public MenuDTO.Get save(MenuDTO.Post post) {
        Menu menu = Menu.builder()
                .name(post.getName())
                .build();


        return menuMapper.EntityToGet(menuRepository.save(menu));
    }
    @Transactional
    public List<MenuDTO.Get> getAllMenus() {
        List<Menu> menuList = menuRepository.findAll();

        List<MenuDTO.Get> rec = new ArrayList<>();
        for (Menu menu :menuList) {
            rec.add(menuMapper.EntityToGet(menu));
        }

        return rec ;
    }
    @Transactional
    public MenuDTO.Get findById(Long id) {

        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu not Found"));

        return menuMapper.EntityToGet(menu);
    }
    @Transactional
    public void delete(Long id) {
        if (!menuRepository.existsById(id)) {
            throw new EntityNotFoundException("해당 메뉴는 존재하지 않습니다." + id);
        }
        menuRepository.deleteById(id);
    }
    @Transactional
    public MenuDTO.Get update(Long id, MenuDTO.Put put) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(("Menu not found")));

        menu.setName(put.getName());


        // 나중에 주석 해제하면 될 듯.
        //menu.setDescription(put.getDescription());

        return menuMapper.EntityToGet(menu);
    }


}
