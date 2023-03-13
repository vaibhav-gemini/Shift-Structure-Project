package com.example.Shift.Structure.Project.Service;

import com.example.Shift.Structure.Project.Entity.Shift;
import com.example.Shift.Structure.Project.Repository.ShiftDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShiftDetailsImp implements ShiftDetails{

    @Autowired
    private ShiftDetailsRepo shiftDetailsRepo;

    Map<String, String> listMap = new HashMap<>();

    List<String> primary = new ArrayList<String>(Arrays.asList("vaibhav", "ishika"));
    List<String> secondary = new ArrayList<String>(Arrays.asList("abhishek", "akshit"));
    List<String> manager = new ArrayList<String>(Arrays.asList("mrinal", "nitish", "ashutosh"));
    List<String> beta = new ArrayList<String>(Arrays.asList("bhist", "divansh"));
    List<String> cloud = new ArrayList<String>(Arrays.asList("ayush", "anirudh"));

    @Override
    public List<Shift> getShiftDetails() {
        return shiftDetailsRepo.findAll();
    }

    @Override
    public Shift addShiftDetails(Shift shift) {
        System.out.println(shift);
        return shiftDetailsRepo.save(shift);
    }

    @Override
    public Shift getShiftById(String id) {
        return shiftDetailsRepo.findById(id).get();
    }

    @Override
    public Shift createNewBShiftFromExisting(Shift shift) {
        Shift prviousShift = shift;
        Shift newShift = new Shift();
        newShift.setShiftId(prviousShift.getShiftId());
        //Setting shift manager
        for(String man : manager){
            if(man.equals(prviousShift.getShiftManager())){
                continue;
            }else {
                System.out.println("Previous shift manager : "+ prviousShift.getShiftManager());
                System.out.println("New shift manager : "+ man);
                listMap.put("Manager",man);
                newShift.setShiftManager(man);
                break;
            }
        }
        //Setting prod primary
        for (String pri : primary){
            if(pri.equals(prviousShift.getProdPrimary())){
                continue;
            }else {
                System.out.println("Previous primary : "+ prviousShift.getProdPrimary());
                System.out.println("New primary : "+ pri);
                listMap.put("Prod Primary",pri);
                newShift.setProdPrimary(pri);
                break;
            }
        }
        //Setting secondary primary
        for (String sec : secondary){
            if(sec.equals(prviousShift.getProdSecondary())){
                continue;
            }else {
                System.out.println("Previous secondary : "+ prviousShift.getProdSecondary());
                System.out.println("New secondary : "+ sec);
                listMap.put("Prod Secondary",sec);
                newShift.setProdSecondary(sec);
                break;
            }
        }
        //Setting beta primary
        for (String b : beta ){
            if(b.equals(prviousShift.getBetaPrimary())){
                continue;
            }else {
                System.out.println("Previous beta primary : "+ prviousShift.getBetaPrimary());
                System.out.println("New beta primary : "+ b);
                listMap.put("Beta Primary",b);
                newShift.setBetaPrimary(b);
                break;
            }
        }
        //Setting cloud primary
        for(String c : cloud){
            if(c.equals(prviousShift.getCloudPrimary())){
                System.out.println("just check : "+ c);
                System.out.println("just check 2 : "+ prviousShift.getCloudPrimary());
                continue;
            }else {
                System.out.println("Previous cloud primary : "+ prviousShift.getCloudPrimary());
                System.out.println("New cloud primary : "+ c);
                listMap.put("Cloud Primary",c);
                newShift.setCloudPrimary(c);
                break;
            }
        }
        System.out.println(listMap);
        shiftDetailsRepo.save(newShift);
        return newShift;
    }

    @Override
    public Shift createNewCShiftFromExisting(Shift shift) {
        Shift newCShift = new Shift();
        newCShift.setShiftManager("prerna");
        newCShift.setCloudPrimary("prerna");
        newCShift.setBetaPrimary(null);
        newCShift.setShiftId(shift.getShiftId());
        newCShift.setProdPrimary("akshit");
        newCShift.setProdSecondary("akshit");
        shiftDetailsRepo.save(newCShift);
        return newCShift;
    }
}
