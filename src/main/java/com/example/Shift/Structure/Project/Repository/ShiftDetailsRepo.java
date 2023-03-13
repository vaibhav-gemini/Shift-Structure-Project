package com.example.Shift.Structure.Project.Repository;

import com.example.Shift.Structure.Project.Entity.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftDetailsRepo extends JpaRepository<Shift, String> {
}
