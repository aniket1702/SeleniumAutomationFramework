package com.testingframework.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.testingframework.enums.CategoryTypes;

/**
 * <p>
 * This class helps us to <b>create Custom Annotation</b>.
 * </p>
 * 
 * 
 * @author ANIKET
 * @version 0.1
 * 
 * 
 */

@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface FrameworkAnnotation {

	/**
	 * 
	 * @return Array of String author from the annotations used in the
	 *         {@link com.testingframework.test} packages.
	 */
	public String[] author() default "";

	/**
	 * 
	 * @return Array of Category Types from the annotations used in the
	 *         {@link com.testingframework.test} packages.
	 * 
	 *         <p>
	 *         Category types can be SANITY, REGRESSION, MINIREGRESSION,
	 *         SMOKE,...etc. as defined in the {@link com.testingframework.enums}
	 *         package.
	 *         </p>
	 * 
	 */
	public CategoryTypes[] category();

}
