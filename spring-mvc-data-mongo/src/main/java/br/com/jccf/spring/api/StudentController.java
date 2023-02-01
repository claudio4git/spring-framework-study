package br.com.jccf.spring.api;

import br.com.jccf.spring.entity.*;
import br.com.jccf.spring.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public StudentDocument create(@RequestBody StudentDocument studentDocument) {
        return service.create(studentDocument);
    }

    @GetMapping("/{id}")
    public StudentDocument get(@PathVariable String id) {
        return service.get(id).orElseThrow();
    }
}
