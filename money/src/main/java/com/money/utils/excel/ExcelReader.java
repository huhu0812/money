package com.money.utils.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelReader {

	private static final int START_ROW = 1;

	private static final int START_COLUMN = 1;

	private static final int END_COLUMN = 10;

	public static void readExcel(String file, Consumer<List<String>> consumer) {
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			readExcelContent(is, consumer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void readExcelContent(InputStream is, Consumer<List<String>> consumer) {
		POIFSFileSystem fs = null;
		HSSFWorkbook wb = null;
		try {
			fs = new POIFSFileSystem(is);
			wb = new HSSFWorkbook(fs);
			Sheet sheet = wb.getSheetAt(0);
			for (int i = START_ROW; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				List<String> columnList = new ArrayList<String>();
				for (int j = START_COLUMN; j < END_COLUMN; j++) {
					String cellValue = row.getCell(j).getStringCellValue();
					if (StringUtils.isNotBlank(cellValue)) {
						columnList.add(cellValue);
					}
				}
				consumer.accept(columnList);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (wb != null) {
				try {
					wb.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fs != null) {
				try {
					fs.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
