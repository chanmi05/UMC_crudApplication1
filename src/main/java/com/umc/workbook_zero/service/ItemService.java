package com.umc.workbook_zero.service;

import com.umc.workbook_zero.dto.ItemDTO;
import com.umc.workbook_zero.entity.Item;
import com.umc.workbook_zero.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service    // Service 클래스 : 비즈니스 로직을 처리하는 서비스 계층
//@Transactional
public class ItemService {

    // UserRepository를 사용해야 하므로 필드로 선언 -> 불변성 유지
    private final ItemRepository itemRepository;    //final 키워드는 한 번 할당된 후 변경되지 않도록 보장해줌 -> 필드가 반드시 생성자에서 초기화되어야 함.

    // Autowired 없이도 Spring Boot에서 생성자가 1개만 있으면 자동으로 주입됨.
    public ItemService(ItemRepository userRepository){
        this.itemRepository = userRepository;
    }

    // 아이템 저장
    public void saveItem(ItemDTO itemDTO){
        Item item = Item.builder()
                .name(itemDTO.getName())
                .count(itemDTO.getCount())
                .build();

        itemRepository.save(item);
    }

    public ItemDTO findItemByID(Long id){
        Item item = itemRepository.findByID(id);

        return ItemDTO.builder()
                .id(item.getId())
                .name(item.getName())
                .count(item.getCount())
                .build();
    }

    // 모든 사용자 조회
    public List<ItemDTO> findAllItem(){
        return itemRepository.findAll()
                .stream()
                .map(item -> ItemDTO.builder()
                                .id(item.getId())
                                .name(item.getName())
                                .count(item.getCount())
                                .build()
                    ).toList();
    }

    public void updateItemByID(Long id, ItemDTO itemDTO){
        Item findItem = itemRepository.findByID(id);
        findItem.updateItem(itemDTO.getName(), itemDTO.getCount());

        itemRepository.updateByID(id, findItem);
    }

    // 사용자 삭제
    public void deleteItemByID(Long id){
        itemRepository.deleteByID(id);
    }

}
