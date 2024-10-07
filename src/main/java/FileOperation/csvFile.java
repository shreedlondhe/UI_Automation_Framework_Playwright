package FileOperation;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class csvFile {
    static String file="/Users/shrinivaslondhe/Desktop/fileeee.xlsx";
    public static void main(String[] args) throws CsvValidationException, IOException {
        csvFile.read();

    }
    static void read() throws IOException, CsvValidationException {
        int a=0;
        try{
            FileInputStream fin = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(fin);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                // Iterate throusheetgh each cell in the row

                System.out.print("   "+row.getCell(a)); // New line after each row
              a+=1;
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}