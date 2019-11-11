package com.donesi.mi.itemservice.repositories;

import com.donesi.mi.itemservice.models.Item;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ItemRepository {

    public List<Item> getItemList() {
        return Collections.singletonList(new Item(1, "Adidas", "Adidas EQT 93/17 GTX", "EUSize:43"));
    }

    public Item getItemById(int itemId) {
        return new Item(1, "Adidas", "Adidas EQT 93/17 GTX", "EUSize:43");
    }
}
