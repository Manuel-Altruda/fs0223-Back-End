package com.GodfathersPizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epicode.GodfathersPizza.classes.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

}
