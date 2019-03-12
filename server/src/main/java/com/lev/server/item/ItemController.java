package com.lev.server.item;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ItemController {

    @RequestMapping("/items")
    public String getAllItems() {
        return "success";
    }
}
