package util;

import java.util.Hashtable;



public class TestUtil {
	public static Object[][] getData(String testName, Xls_Reader xls){
		//find the test in the xls file
		//find the number of column on the test
		//find the number of rows on the test
		//print the data on the test
		//put the data in the object array
		
		int testCaseStartIndex = 0;
		
		//*******reading the data******//
		//get the row number for each HEAD set of test 
		for (int rowNumb = 1; rowNumb <= xls.getRowCount("TestData"); rowNumb++ ) {
			
			if (testName.equals(xls.getCellData("TestData", 0, rowNumb))){
				testCaseStartIndex = rowNumb;
				break;
			}
		}
		
		System.out.println("print testCaseStart index =" + " " + testCaseStartIndex);
		
		//Total Columns
		int colStartIndex=testCaseStartIndex+1;
		int cols=0;
		while(!xls.getCellData("TestData", cols, colStartIndex).equals("")){
			cols++;
		}
		
		System.out.println("Total cols are  - "+cols);
		
		//Total Rows
		int dataStartIndex=testCaseStartIndex+2;
		int rows=0;
		while(!xls.getCellData("TestData", 0, (dataStartIndex+rows)).equals("")){
			rows++;
		}
		
		System.out.println("Total rows are - "+rows);
		
		//print data
		Object[][] data = new Object[rows][1];
		Hashtable<String,String> table = null;
		for(int rNum=dataStartIndex;rNum<(dataStartIndex+rows);rNum++){
			table = new Hashtable<String,String>();
			for(int cNum=0;cNum<cols;cNum++){
				table.put(xls.getCellData("TestData", cNum, colStartIndex), xls.getCellData("TestData", cNum, rNum));
				System.out.print(xls.getCellData("TestData", cNum, rNum)+" -- ");
			}
			System.out.println();
			data[rNum-dataStartIndex][0]=table;
		}
		System.out.println();
		return data;
	}
	

}
