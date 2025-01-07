package com.ti.blog.entity;

public class Grade {
    public char determineLetterGrade(int numberGrade) {
        if (numberGrade < 0) {
            throw new IllegalArgumentException("Number grade cannot be resolved");
        }

        if (numberGrade < 60) {
            return 'F';
        }

        if (numberGrade < 70) {
            return 'D';
        }

        if (numberGrade < 80) {
            return 'C';
        }
        if (numberGrade < 90) {
            return 'B';
        }

        return 'A';
    }
}
