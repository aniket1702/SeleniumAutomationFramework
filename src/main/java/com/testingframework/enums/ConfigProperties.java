package com.testingframework.enums;

/**
 * <p>
 * This Enum is used to define the sets of values which will be retrived from
 * the <b>config.properties</b> file and will be used globally in the Framework.
 * </p>
 *
 * 01-Nov-2021
 * 
 * @author ANIKET
 * @version 1.0
 * 
 * @see com.testingframework.enums.CategoryTypes
 * @see com.testingframework.enums.WaitStrategy
 */
public enum ConfigProperties {

	URL, OVERRIDEREPORTS, PASSEDSCREENSHOTS, FAILEDSCREENSHOTS, SKIPPEDSCREENSHOTS, RETRYFAILEDTESTS, RUNMODE,
	SENDRESULTTOELK, SELENIUMGRIDURL, ELASTICSEARCHURL, BROWSER;
}
