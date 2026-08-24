package com.coffeeshop.shift_api.service;

import com.coffeeshop.shift_api.entity.Shift;
import com.coffeeshop.shift_api.repository.ShiftRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ShiftService {

    private final ShiftRepository shiftRepository;

    public ShiftService(ShiftRepository shiftRepository) {
        this.shiftRepository = shiftRepository;
    }

    public Shift scheduleShift(Shift newShift) {
        List<Shift> existingShifts = shiftRepository.findByStaffId(newShift.getStaff().getId());


        for (Shift existingShift : existingShifts) {

            boolean startsBeforeExistingEnds = newShift.getStartTime().isBefore(existingShift.getEndTime());

            boolean endsAfterExistingStarts = newShift.getEndTime().isAfter(existingShift.getStartTime());

            if (startsBeforeExistingEnds && endsAfterExistingStarts) {

                throw new ResponseStatusException(HttpStatus.CONFLICT, "Error: Barista is double-booked!");
            }
        }

        return shiftRepository.save(newShift);

    }

    // Fetch all shifts for a specific barista
    public List<Shift> getShiftsForStaff(Long staffId) {
        return shiftRepository.findByStaffId(staffId);
    }
}
