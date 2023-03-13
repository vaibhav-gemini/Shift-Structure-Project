package com.example.Shift.Structure.Project.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Shift_Structure")
public class Shift {
    @Id
    @Column(name = "Shift_ID")
    private String shiftId;
    @Column(name = "Prod_Primary")
    private String prodPrimary;
    @Column(name = "Prod_Secondary")
    private String prodSecondary;
    @Column(name = "Beta_Primary")
    private String betaPrimary;
    @Column(name = "Cloud_Primary")
    private String cloudPrimary;
    @Column(name = "Shift_Manager")
    private String shiftManager;
}
