package rough;

import utilities.ExcelReader;

public class TestExcel {
	
	public static final String  sheetName = "Sheet1";

	public static void main(String[] args) {
		
		String path = "./TestData/TestData.xlsx";
		
		System.out.println("Path: " + path);
		ExcelReader excel = new ExcelReader(path);
		int rows = excel.getRowCount(sheetName);
		int columns = excel.getColumnCount("Sheet1");
		System.out.println("Total Rows: " + rows);
		System.out.println("Total columns: " + columns);

		for (int i = 1; i <=rows; rows++) {
			for (int j = 0; j < columns; j++) {
				System.out.println(excel.getCellData(sheetName, j, i));
			}
		}

	}

}
