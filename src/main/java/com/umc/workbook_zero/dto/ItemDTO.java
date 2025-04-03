package com.umc.workbook_zero.dto;

import lombok.Builder;
import lombok.Data;


@Data
public class ItemDTO {
    private Long id;
    private String name;
    private Long count;

    @Builder
    public ItemDTO(Long id, String name, Long count){
        this.id = id;
        this.name = name;
        this.count = count;
    }
}
