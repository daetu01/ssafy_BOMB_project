package com.ssafy.bomb.menu.repository;

import com.ssafy.bomb.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
