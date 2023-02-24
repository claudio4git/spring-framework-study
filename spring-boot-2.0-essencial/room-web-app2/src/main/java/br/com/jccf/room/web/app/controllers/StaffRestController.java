package br.com.jccf.room.web.app.controllers;

import br.com.jccf.room.web.app.models.*;
import br.com.jccf.room.web.app.services.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/staffs")
public class StaffRestController {
    private final StaffService staffService;

    public StaffRestController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public List<Staff> getAllStaffs() {
        return staffService.getAllStaffs();
    }
}
