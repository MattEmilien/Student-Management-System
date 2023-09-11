package me.student.system.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import me.student.system.validator.model.ValidGrade;

public class GradeValidator implements ConstraintValidator<ValidGrade, double[]> {

    @Override
    public void initialize(ValidGrade constraintAnnotation) {
    }

    @Override
    public boolean isValid(double[] grades, ConstraintValidatorContext context) {
        return grades == null ||
          java.util.Arrays.stream(grades).allMatch(grade -> grade >= 0.0 && grade <= 100.0);
    }
}
