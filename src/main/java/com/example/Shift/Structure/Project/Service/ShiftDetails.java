package com.example.Shift.Structure.Project.Service;

import com.example.Shift.Structure.Project.Entity.Shift;

import java.util.List;

public interface ShiftDetails {
    public List<Shift> getShiftDetails();
    public Shift addShiftDetails(Shift shift);
    public Shift getShiftById(String id);

    public Shift createNewBShiftFromExisting(Shift shift);
    public Shift createNewCShiftFromExisting(Shift shift);
}
