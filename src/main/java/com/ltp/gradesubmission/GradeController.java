package com.ltp.gradesubmission;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GradeController {

    List<Grade> studentGrades = new ArrayList<>();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String name){      
        model.addAttribute("grade", getGradeIndex(name) == -1000 ? new Grade() : studentGrades.get(getGradeIndex(name)));
        return "form";
    }

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", studentGrades);
        return "grades";
    }
    
    @PostMapping("/handleSubmit")
    public String submitForm(Grade grade){
        int index = getGradeIndex(grade.getName());
        if(index == -1000){
            studentGrades.add(grade);
        } else {
            studentGrades.set(index, grade);
        }
        return "redirect:/grades";
    }

    public Integer getGradeIndex(String name){
        for(int i = 0; i < studentGrades.size(); i++){
            if (studentGrades.get(i).getName().equals(name)) return i;
        } 
        return -1000;
    }
    
    
}
