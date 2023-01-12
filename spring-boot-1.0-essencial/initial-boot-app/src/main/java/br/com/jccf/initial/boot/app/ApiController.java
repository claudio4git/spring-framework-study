package br.com.jccf.initial.boot.app;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping
    String greeting() {
        return "Hello World from the API";
    }
}
