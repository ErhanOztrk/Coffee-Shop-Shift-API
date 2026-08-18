package com.coffeeshop.shift_api.controller;

import com.coffeeshop.shift_api.entity.Shift;
import com.coffeeshop.shift_api.service.ShiftService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shifts")
public class ShiftController {

    private final ShiftService shiftService;

    public ShiftController(ShiftService shiftService) {
        this.shiftService = shiftService;
    }

    @PostMapping
    public ResponseEntity<Shift> createShift(@RequestBody Shift newShift) {

        Shift savedShift = shiftService.scheduleShift(newShift);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedShift);
    }
}
