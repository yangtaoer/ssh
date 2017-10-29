package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {
	
	public static void main(String[] args) throws Exception {
		//����������
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet9 = workbook.createSheet();
		//����������
		/*XSSFSheet sheet = workbook.createSheet();
		
		//������
		XSSFRow row0 = sheet.createRow(0);
		XSSFRow row1 = sheet.createRow(1);
		XSSFRow row2 = sheet.createRow(2);
		//�����ڴ�����Ԫ��
		XSSFCell cell = row0.createCell(0);
		cell.setCellValue("���");
		row0.createCell(1).setCellValue("����");
		row0.createCell(2).setCellValue("����");
		//������ݵ�һ��
		row1.createCell(0).setCellValue(1);
		row1.createCell(1).setCellValue("������");
		row1.createCell(2).setCellValue(1);
		//�ڶ���
		row2.createCell(0).setCellValue(2);
		row2.createCell(1).setCellValue("����");
		row2.createCell(2).setCellValue(3);*/
		for(int i=1;i<10;i++){
			//String name = "row"+String.valueOf(i);
			XSSFRow row = sheet9.createRow(i);
			for(int j=1;j<=i;j++){
				int num = i*j;
				row.createCell(j).setCellValue(i+"*"+j+"="+num);
			}
		}
		FileOutputStream out = new FileOutputStream("demo.xlsx");
		workbook.write(out);
		workbook.close();
		
		
	
		
	}
}	
