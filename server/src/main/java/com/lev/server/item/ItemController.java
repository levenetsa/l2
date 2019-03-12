package com.lev.server.item;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
public class ItemController {

    @RequestMapping("/items")
    public String getAllItems() {
        return "success";
    }
}
