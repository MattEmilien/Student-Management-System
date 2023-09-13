package me.student.system.validator.grade;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GradeValidator.class)
@Documented
public @interface ValidGrade {

    String message() default "Invalid grades";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
