package tests;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExel {

    @Test
    public void testReadExel() throws IOException {

        String path = "./src/test/resources/Capitals.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);

        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(2);
        Cell cell = row.getCell(2);

        System.out.println(cell);

        // Ard arda yazılaraka aşağıdaki gibi bir zincir oluşturulabilir.
        String data = workbook.getSheetAt(0).getRow(3).getCell(1).getStringCellValue();
        System.out.println(data);

        // toplam satır sayısını aşağıdaki metod ile alabiliriz.
        int rowCount = sheet.getLastRowNum();
        System.out.println("rowCount = " + rowCount);

        int numberOfPhysicalRows = sheet.getPhysicalNumberOfRows();
        System.out.println("numberOfPhysicalRows = " + numberOfPhysicalRows);

        System.out.println("=====================================================================");
        Map<String, String> capitals = new HashMap<>(); // Aşağıdaki döngü ile exelden çekeceğimiz datayı Map'e atarak kullanabilmek için bu Map'i oluşturduk.

        int countryColumn = 0;
        int capitalColumn = 1;
        int famousForColumn = 2;

        for (int rowNumber = 1; rowNumber<= rowCount; rowNumber++) {

            String country = sheet.getRow(rowNumber).getCell(countryColumn).toString();
            String capital = sheet.getRow(rowNumber).getCell(capitalColumn).toString();
            String famousFor = sheet.getRow(rowNumber).getCell(famousForColumn).toString();
            System.out.println("country = " + country + "\t\t\tcapital = " +capital +"\t\t\tfamousFor = " +famousFor);
            capitals.put(country, capital);
        }

        System.out.println("=====================================================================");
        System.out.println(capitals);
        System.out.println("=====================================================================");
    }
}
