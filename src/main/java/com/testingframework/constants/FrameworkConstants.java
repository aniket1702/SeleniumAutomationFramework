package com.testingframework.constants;

import com.testingframework.enums.ConfigProperties;
import com.testingframework.utils.ConfigReader;

/**
 * <p>
 * This class helps us to declare all the <b>Constant Variables</b> which will
 * be used globally using <b>getter</b> method.
 * </p>
 * <p>
 * Class declared as Final so that no other class can extend this class.
 * </p>
 * 01-Nov-2021
 * 
 * @author ANIKET
 * @version 1.0
 * 
 * @see src.test.resources.config/config.properties
 * 
 *
 */

public final class FrameworkConstants {

	/*
	 * 
	 * Private constructor declared so that new instances cannot be created by any
	 * other class
	 */
	/**
	 * 
	 * Private constructor is declared to avoid external Instantiation.
	 */
	private FrameworkConstants() {

	}

	private static final String BASEPATH = System.getProperty("user.dir");
	private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources/";
	private static final String CHROMEDRIVERPATH = RESOURCESPATH + "executables/chromedriver.exe";
	private static final String FIREFOXDRIVERPATH = RESOURCESPATH + "executables/geckodriver.exe";
	private static final String CONFIGFILEPATH = RESOURCESPATH + "config/config.properties";
	private static final String EXTENTREPORTFOLDERPATH = BASEPATH + "/test-output/sparkReport/";
	private static final String EXCELPATH = RESOURCESPATH + "excel/testing.xlsx";
	private static String extentReportFilePath = "";
	private static final int EXPICITWAIT = 10;
	private static final String RUNMANAGERSHEET = "RUNMANAGER";
	private static final String DATASHEET = "DATA";

	/**
	 * 
	 * @return EXPLICITWAIT
	 *         <p>
	 *         A wait condition for an element to be VISIBLE, PRESENCE,
	 *         CLICKABLE..etc.
	 *         </p>
	 */
	public static int getExpicitWait() {
		return EXPICITWAIT;
	}

	/**
	 * 
	 * @return EXTENTREPORTFILEPATH
	 *         <p>
	 *         This method returns the File Path to
	 *         {@link com.testingframework.reports.ExtentReport}
	 *         </p>
	 *         <p>
	 *         If Extent Report File Path is empty it will create a new folder with
	 *         current time in milliseconds which will fetch the report from method
	 *         {@link FrameworkConstants#getExtentReportFolderPath()}
	 *         </p>
	 */
	public static String getExtentReportFilePath() {
		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = getExtentReportFolderPath();
		}
		return extentReportFilePath;
	}

	/**
	 * 
	 * @return EXTENTREPORTFOLDERPATH
	 *         <p>
	 *         This method gets input from cofig.properties file which can be
	 *         modified manually as per requirement from business.
	 * 
	 *         </p>
	 *         <p>
	 *         If <b>OVERRIDEREPORTS</b> is selected <b>no</b> the reports will be
	 *         generated with current time in milliseconds else report will be
	 *         generated without time.
	 * 
	 *         </p>
	 */
	public static String getExtentReportFolderPath() {
		if (ConfigReader.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH + System.currentTimeMillis() + "/sparkReport.html";
		} else {
			return EXTENTREPORTFOLDERPATH + "sparkReport.html";
		}
	}

	/**
	 * 
	 * @return CHROMEDRIVERPATH from the resources folder.
	 * 
	 */
	public static String getChromeDriverPath() {
		return CHROMEDRIVERPATH;
	}

	/**
	 * 
	 * @return CONFIGFILEPATH from the resources folder.
	 */
	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

	/**
	 * 
	 * @return EXCELPATH from the resources folder.
	 */
	public static String getExcelPath() {
		return EXCELPATH;
	}

	/**
	 * 
	 * @return RUNMANAGERSHEET
	 *         <p>
	 *         It will return the sheet with name RUNMANAGER from Excel sheet.
	 *         </p>
	 */
	public static String getRunManagersheet() {
		return RUNMANAGERSHEET;
	}

	/**
	 * 
	 * @return DATASHEET
	 *         <p>
	 *         It will return the sheet with name DATASHEET from Excel sheet.
	 *         </p>
	 */
	public static String getDatasheet() {
		return DATASHEET;
	}

	/**
	 * 
	 * @return FIREFOXDRIVERPATH from the resources folder.
	 */
	public static String getFirefoxDriverPath() {
		return FIREFOXDRIVERPATH;
	}

}
