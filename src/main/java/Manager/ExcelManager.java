package Manager;

import Bean.ExcelBean;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ExcelManager {
    private static List<ExcelBean> excels;

    public static void init() {
        try {
            List<ExcelBean> list = new ArrayList<>();
            HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(new FileInputStream("excel.xls")));
            HSSFSheet sheet = workbook.getSheetAt(0);
            if (sheet != null)
                for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                    HSSFRow row = sheet.getRow(i);
                    long QQ = new Double(row.getCell(0).getNumericCellValue()).longValue();
                    String name = new String(row.getCell(1).getStringCellValue().getBytes(StandardCharsets.UTF_8));
                    String role = "";
                    if (row.getCell(2) != null)
                        role = new String(row.getCell(2).getStringCellValue().getBytes(StandardCharsets.UTF_8));
                    list.add(new ExcelBean(QQ, name, role));
                }
            excels = list;
        } catch (IOException e) {
            e.printStackTrace();
            excels = new ArrayList<>();
        }
    }

    public static List<ExcelBean> getExcels() {
        return excels;
    }
}