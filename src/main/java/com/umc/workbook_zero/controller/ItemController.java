package com.umc.workbook_zero.controller;

import com.umc.workbook_zero.dto.ItemDTO;
import com.umc.workbook_zero.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // REST API를 만들 때, JSON 형식으로 반환할 때는 RestController 사용!
// vs @Controller : HTML 페이지(뷰) 렌더링을 위한 컨트롤러, 뷰를 반환할 때 사용
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    // 아이템 저장
    @PostMapping
    public void save(@RequestBody ItemDTO itemDTO){
        itemService.saveItem(itemDTO);
    }
    // id로 해당 아이템 찾기
    @GetMapping("/{id}")
    public ItemDTO findItemByID(@PathVariable Long id){
        return itemService.findItemByID(id);
    }

    @PatchMapping("/{id}")
    public void updateItemByID(@PathVariable Long id, @RequestBody ItemDTO itemDTO){
        itemService.updateItemByID(id, itemDTO);
    }

    @GetMapping
    public List<ItemDTO> findAllItem(){
        return itemService.findAllItem();
    }

    @DeleteMapping("/{id}")
    public void deleteItemByID(@PathVariable Long id){
        itemService.deleteItemByID(id);
    }
}
