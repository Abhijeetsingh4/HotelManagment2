package com.oyo.HotelManagment2.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // This means the annotation can be applied to methods
@Retention(RetentionPolicy.RUNTIME) // The annotation will be available at runtime for reflection
public @interface Log {
//    String value() default ""; // Optional message that can be used for custom log details
}