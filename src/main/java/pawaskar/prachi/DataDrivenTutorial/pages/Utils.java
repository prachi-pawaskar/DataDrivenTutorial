package pawaskar.prachi.DataDrivenTutorial.pages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Utils {

    //Method that reads excel and returns object to be used by data provider
    public static Object[][] readExcel(String excelPath) throws IOException {
        XSSFSheet ExcelWSheet;
        XSSFWorkbook ExcelWBook;
        // Open the Excel file
        String resourceFilePath = excelPath;
        String resourceURL = new File(resourceFilePath).getAbsolutePath();
        File Path = new File(resourceURL);
        FileInputStream ExcelFile = new FileInputStream(Path);
        // Access the required test data sheet
        ExcelWBook = new XSSFWorkbook(ExcelFile);
        // Set default sheet to first
        ExcelWSheet = ExcelWBook.getSheetAt(0);
        ArrayList<ArrayList<String>> md = new ArrayList<ArrayList<String>>();
        //Get total rows
        int totalRows = ExcelWSheet.getLastRowNum();
        int totalCols = ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
        Object[] active = new Object[totalCols];
        //Loop till row ends
        for (int i = 0; i <= totalRows; i++) {
            //add row wise data to object array
            for (int j = 0; j < totalCols; j++) {
                String temp = ExcelWSheet.getRow(i).getCell(j).toString();
                active[j] = temp;
            }
            ArrayList<String> row = new ArrayList<String>();
            for(int p=0;p<active.length;p++){
                row.add(active[p].toString());
            }
            md.add(row);
        }

        Object[][] data = new Object[md.size()][active.length];
        //initialize data
        int index=0;
        for(ArrayList<String> r : md){
            for(int i=0;i<r.size();i++){
                data[index][i] = r.get(i).toString();
            }
            ++index;
        }

        //Display data object
        System.out.println("Printing excel sheet");
        for (Object[] r : data)
            System.out.println(Arrays.toString(r));

        return data;
    }

    //Method that reads excel and returns object to be used by data provider
    //It reads only entries which are marked as Active in first column
    public static Object[][] readCsv(String csvFile) throws IOException {
        //Reading Active script names
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        br = new BufferedReader(new FileReader(csvFile));

        ArrayList<ArrayList<String>> md = new ArrayList<ArrayList<String>>();
        Object[] active = null;


        while ((line = br.readLine()) != null) {
            if (line.startsWith("#")){
                //Don't read the line, it's a comment
            } else {
                active = line.split(cvsSplitBy);
                if (active[0].toString().equalsIgnoreCase("active")) {
                    ArrayList<String> row = new ArrayList<String>();
                    for(int i=1;i<active.length;i++){
                        row.add(active[i].toString());
                    }
                    md.add(row);
                }
            }
        }
        Object[][] data = new Object[md.size()][active.length-1];
        //initialize data
        int index=0;
        for(ArrayList<String> r : md){
            for(int i=0;i<r.size();i++){
                data[index][i] = r.get(i).toString();
            }
            ++index;
        }
        return data;
    }

}
