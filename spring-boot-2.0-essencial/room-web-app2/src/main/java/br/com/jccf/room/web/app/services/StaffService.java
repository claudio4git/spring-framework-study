package br.com.jccf.room.web.app.services;

import br.com.jccf.room.web.app.models.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class StaffService {

    private static final List<Staff> staffs = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            staffs.add(new Staff(UUID.randomUUID(), "Name " + i, "R" + i, StaffPosition.STAFF.toString()));
        }
    }

    public List<Staff> getAllStaffs() {
        return staffs;
    }
}
