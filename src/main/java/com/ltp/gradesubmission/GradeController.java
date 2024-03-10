package com.ltp.gradesubmission;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class GradeController {

    List<Grade> studentGrades = new ArrayList<>();

    @GetMapping("/grades")
    public String getGrades(Model model) {
        studentGrades.add(new Grade("Harry", "Poisons", "C-"));
        studentGrades.add(new Grade("Hermiony", "Arithmetics", "A+"));
        studentGrades.add(new Grade("Neville", "Charms", "A-"));
        model.addAttribute("grades", studentGrades);
        return "grades";
    }

    
    
}
