package org.ort.starwars.fleet.constrollers;

import org.ort.starwars.fleet.configuration.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class ApiRootController {

    @Autowired
    private Settings settings;

    @GetMapping("/")
    public String get() {
        return settings.getVersion();
    }
}
