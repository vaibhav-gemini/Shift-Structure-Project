package com.example.Shift.Structure.Project.Controller;

import com.example.Shift.Structure.Project.Entity.Shift;
import com.example.Shift.Structure.Project.Service.ShiftDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShiftDetailsController {
    @Autowired
    private ShiftDetails shiftDetails;
    @GetMapping(path = "/oldShift")
    public List<Shift> getShiftDetails(){
        return shiftDetails.getShiftDetails();
    }
    @PostMapping("/shift")
    public Shift addShiftDetails(@RequestBody Shift shift){
        return shiftDetails.addShiftDetails(shift);
    }
    @PostMapping("/newBShift")
    public Shift getNewBShiftStructure( @RequestBody  Shift shift){
        return shiftDetails.createNewBShiftFromExisting( shift);
    }
    @PostMapping("/newCShift")
    public Shift getNewCShiftStructure( @RequestBody  Shift shift){
        return shiftDetails.createNewCShiftFromExisting( shift);
    }
    @GetMapping("/great")
    public String greatPeople(){
        return "Hello how are you!";
    }
}
