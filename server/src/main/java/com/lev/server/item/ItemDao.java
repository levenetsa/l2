package com.lev.server.item;

import com.lev.server.utils.ResultSetConverter;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ItemDao {

    @Autowired
    DataSource dataSource;

    public JSONArray getById(int id) throws SQLException {
        return execute("SELECT * FROM etcitem WHERE item_id = " + id);
    }

    public JSONArray getRaw() throws SQLException {
        return execute("SELECT * FROM etcitem");
    }

    public JSONArray search(String text) throws SQLException {
        return execute("SELECT item_id, name, icon FROM etcitem WHERE name like '%" + text + "%'");
    }

    private JSONArray execute(String sql) throws SQLException {
        JSONArray array;
        try (Connection connection = dataSource.getConnection()) {
            ResultSet set = connection.prepareStatement(sql).executeQuery();
            array = ResultSetConverter.convertAr(set);
        }
        return array;
    }

    public String addItem(Item item) {
        //execute sql to add item
        return null;
    }
}
