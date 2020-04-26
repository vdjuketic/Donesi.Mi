package com.donesi.mi.itemservice;

import com.donesi.mi.itemservice.models.Item;
import com.donesi.mi.itemservice.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemResource {

  private ItemRepository itemRepository;

  @Autowired
  public ItemResource(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  @RequestMapping("/list")
  public List<Item> getItemList() {
    return itemRepository.getItemList();
  }

  @RequestMapping("/{itemId}")
  public Item getItemById(@PathVariable("itemId") int itemId) {
    return itemRepository.getItemById(itemId);
  }
}
