package com.lev.server.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping("/items")
    public String getAllItems() throws SQLException {
        return itemService.getAllItems();
    }

    @PutMapping
    @RequestMapping("/item")
    public String getAdd(@RequestBody Item item) throws SQLException {
        return itemService.createNewItem(item);
    }

    @RequestMapping("/items/{id}")
    public String getItemById(@PathVariable int id) throws SQLException {
        return itemService.getItemById(id);
    }

    @RequestMapping("/items/search")
    public String search(@RequestParam String text) throws SQLException {
        return itemService.search(text);
    }
}
