package com.lev.server.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class ItemController {

    @Autowired
    ItemDao itemDao;

    @RequestMapping("/items")
    public String getAllItems() throws SQLException {
        return itemDao.getRow().toString();
    }

    @RequestMapping("/items/{id}")
    public String getItemById(@PathVariable int id) throws SQLException {
        return itemDao.getById(id).toString();
    }

    @RequestMapping("/items/search")
    public String search(@RequestParam String text) throws SQLException {
        return itemDao.search(text).toString();
    }
}
