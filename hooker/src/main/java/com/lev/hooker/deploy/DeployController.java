package com.lev.hooker.deploy;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class DeployController {

    @RequestMapping("/")
    public String index(@RequestParam String diff) {
        return diff;
    }

}
