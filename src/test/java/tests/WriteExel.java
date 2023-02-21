package tests;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteExel {

    @Test
    public void testWriteExel() throws IOException {

        String path = "./src/test/resources/Capitals.xlsx";
        FileInputStream file = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(file);   //OPENING the workbook

        Sheet sheet = workbook.getSheetAt(0);            //getting the first sheet
        Row row = sheet.getRow(0);                       //getting the first row
        Cell cell = row.createCell(4);                   //CREATING a cell
        cell.setCellValue("POPULATION");

        workbook.getSheetAt(0).getRow(1).createCell(4).setCellValue("100000000");
        workbook.getSheetAt(0).getRow(2).createCell(4).setCellValue("200000000");
        workbook.getSheetAt(0).getRow(3).createCell(4).setCellValue("300000000");
        workbook.getSheetAt(0).getRow(4).createCell(4).setCellValue("400000000");

        List<String> list = new ArrayList<>();
        list.add("4567898");
        list.add("123456");
        list.add("1234567");
        list.add("12345678");

        for (int i = 0; i < list.size(); i++) {
            workbook.getSheetAt(0).getRow(i + 5).createCell(4).setCellValue(list.get(i));
        }

        // Alttaki işlemler olmadan Exel dosyasına bilgiler yazdırılmaz.
        FileOutputStream fileOut = new FileOutputStream(path);
        workbook.write(fileOut);         //WRITING on the cell and saving the workbook
        fileOut.close();                 //CLOSING is IMPORTANT
        file.close();
        workbook.close();

    }
}
