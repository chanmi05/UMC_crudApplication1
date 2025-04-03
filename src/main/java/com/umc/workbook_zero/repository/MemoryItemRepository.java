package com.umc.workbook_zero.repository;

import com.umc.workbook_zero.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryItemRepository implements ItemRepository {

    private static Map<Long, Item> store = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public void save(Item item) {
        item.initID(++sequence);
        store.put(item.getId(), item);
    }

    @Override
    public Item findByID(Long id) {
        return store.get(id);
    }

    @Override
    public List<Item> findAll() {
        return store.values().stream().toList();
    }

    @Override
    public void updateByID(Long id, Item item) {
        store.put(id, item);
    }

    @Override
    public void deleteByID(Long id) {
        store.remove(id);
    }
}
