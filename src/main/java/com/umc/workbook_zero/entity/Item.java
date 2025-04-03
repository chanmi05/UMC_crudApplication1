package com.umc.workbook_zero.entity;

//import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter

//@Entity // Entity 클래스 : db의 한 테이블을 객체로 표현한 것
public class Item {
    private long id;
    private String name;
    private Long count;

    @Builder
    public Item(String name, Long count){
        this.name = name;
        this.count = count;
    }

    public void initID(Long id){
        this.id = id;
    }

    public void updateItem(String name, Long count){
        this.name = name;
        this.count = count;
    }

}
