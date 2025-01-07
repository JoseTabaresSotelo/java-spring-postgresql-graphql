package com.ti.blog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.ti.blog.entity.Grade;

public class GradeTest {
    @Test
    void fiftyShouldReturnF() {
        var grade = new Grade();
        assertEquals('F', grade.determineLetterGrade(50));
    }

    @Test
    void sixtyShouldReturnD() {
        var grade = new Grade();
        assertEquals('D', grade.determineLetterGrade(60));
    }

    @Test
    void seventyNineShouldReturnC() {
        var grade = new Grade();
        assertEquals('C', grade.determineLetterGrade(79));
    }

    @Test
    void eightyShouldReturnB() {
        var grade = new Grade();
        assertEquals('B', grade.determineLetterGrade(80));
    }

    @Test
    void ninetyNineShouldReturnA() {
        var grade = new Grade();
        assertEquals('A', grade.determineLetterGrade(99));
    }

    @Test
    void oneHundredShouldReturnA() {
        var grade = new Grade();
        assertEquals('A', grade.determineLetterGrade(100));
    }

    @Test
    void negativeOneShouldReturnIllegalArgumentException() {
        var grade = new Grade();
        assertThrows(IllegalArgumentException.class, () -> {
            grade.determineLetterGrade(-1);
        });
    }

}
