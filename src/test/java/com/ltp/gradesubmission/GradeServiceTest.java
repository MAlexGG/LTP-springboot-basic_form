package com.ltp.gradesubmission;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ltp.gradesubmission.repository.GradeRepository;
import com.ltp.gradesubmission.service.GradeService;

@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {

    @Mock
    private GradeRepository gradeRepository;

    @InjectMocks
    private GradeService gradeService;

    /* Este test es demasiado simple y no testea lógica */
    @Test 
    public void getGradesFromRepoTest(){
        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(
            new Grade("Harry", "Potions", "C"),
            new Grade("Hermioni", "Maths", "A+")
        ));

        List<Grade> result = gradeService.getGrades();

        assertEquals("Harry", result.get(0).getName());
        assertEquals("Maths", result.get(1).getSubject());   
    }

    /* Es mejor testear métodos que contengan lógica como getGradeIndex */

    @Test
    public void gradeIndexText(){
        Grade grade = new Grade("Harry", "Potions", "C");
        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(grade));

       int valid = gradeService.getGradeIndex(grade.getId());
       int notFound = gradeService.getGradeIndex("123");

       assertEquals(0, valid);
       assertEquals(Constants.NOT_FOUND, notFound);
    }
}
