package br.com.jccf.room.web.app.controllers;

import br.com.jccf.room.web.app.services.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/staffs")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public String getAllRooms(Model model) {
        model.addAttribute("staffs", staffService.getAllStaffs());
        return "staffs";
    }
}
