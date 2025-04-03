package com.umc.workbook_zero.repository;

import com.umc.workbook_zero.entity.Item;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Repository 인터페이스 : DB에 접근하는 역할을 하는 인터페이스
// JPA를 이용해 Repository로 SQL을 직접 작성하지 않고도 Entity 클래스의 데이터를 CRUD 수행가능!
public interface ItemRepository {
    void save(Item item);   //create
    Item findByID(Long id);   //read
    List<Item> findAll(); //read
    void updateByID(Long id, Item item);
    void deleteByID(Long id);

}
