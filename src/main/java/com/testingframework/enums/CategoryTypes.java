package com.testingframework.enums;

/**
 * <p>
 * Enum to store Test Category Types which will be used by the classes present
 * in the package {@link com.testingframework.test}
 * </p>
 * <p>
 * This limits the testers to use their own Test Category Types in the testing
 * Framwork.
 * </p>
 * 01-Nov-2021
 * 
 * @author ANIKET
 * @version 1.0
 * 
 * @see com.testingframework.enums.WaitStrategy
 * @see com.testingframework.enums.ConfigProperties
 */
public enum CategoryTypes {
	SANITY, REGRESSION, SMOKE, MINIREGRESSION;

}
