package ru.taranov.springmvcdemo.validation;

import ru.taranov.springmvcdemo.validation.CourseCode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator
        implements ConstraintValidator<CourseCode, String> {

    private String[] coursePrefixes;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefixes = theCourseCode.value();

    }

    @Override
    public boolean isValid(String theCode,
                           ConstraintValidatorContext constraintValidatorContext) {

        boolean result = false;

        if (theCode != null) {
            for (String tempPrefix : coursePrefixes) {
                result = theCode.startsWith(tempPrefix);
                if (result) {
                    break;
                }
            }
        } else {
            result = true;
        }
        return result;
    }
}
