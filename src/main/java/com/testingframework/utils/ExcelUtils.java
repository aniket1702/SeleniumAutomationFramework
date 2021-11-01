package com.testingframework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.testingframework.constants.FrameworkConstants;
import com.testingframework.exceptions.FilePathNotFoundException;
import com.testingframework.exceptions.FrameworkExceptions;

public final class ExcelUtils {

	private ExcelUtils() {

	}

	public static List<Map<String, String>> getDetails(String sheetName) {

		List<Map<String, String>> list = null;
		DataFormatter formatter = new DataFormatter();
		try (FileInputStream fs = new FileInputStream(FrameworkConstants.getExcelPath())) {

			XSSFWorkbook workbook = new XSSFWorkbook(fs);

			XSSFSheet sheet = workbook.getSheet(sheetName);

			// Fetch Last Row number and Last column number from excel sheet
			int lastrownum = sheet.getLastRowNum();
			int lastcolnum = sheet.getRow(0).getLastCellNum();

			Map<String, String> map = null;
			list = new ArrayList<>();

			// Iterate Excel sheet
			for (int i = 1; i <= lastrownum; i++) {
				map = new HashMap<>();
				for (int j = 0; j < lastcolnum; j++) {

					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = formatter.formatCellValue(sheet.getRow(i).getCell(j));

					map.put(key, value);

				}
				list.add(map);

			}
		} catch (FileNotFoundException e1) {

			throw new FilePathNotFoundException("Excel file trying to read is not found.");
		} catch (IOException e) {

			throw new FrameworkExceptions("IOException Occured!!!.");
		}

		return list;

	}
}
