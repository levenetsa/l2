package com.lev.server.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ItemService {

    @Autowired
    ItemDao itemDao;

    String getAllItems() throws SQLException {
        return itemDao.getRaw().toString();
    }

    String getItemById(int id) throws SQLException {
        return itemDao.getById(id).toString();
    }

    String search(String text) throws SQLException {
        return itemDao.search(text).toString();
    }

    public String createNewItem(Item item) {
        return itemDao.addItem(item);
    }
}
