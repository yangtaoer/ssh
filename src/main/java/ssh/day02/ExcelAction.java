package ssh.day02;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

public class ExcelAction {
	private String type;
	private InputStream excel;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public InputStream getExcel() {
		return excel;
	}
	public void setExcel(InputStream excel) {
		this.excel = excel;
	}
	public String execute() throws IOException {
	
		type="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
		excel = createExcel();
		return "success";
	}
	
	public InputStream createExcel() throws IOException{
		//创建工作簿
		XSSFWorkbook workbook = new XSSFWorkbook();
		//创建工作表
		XSSFSheet sheet9 = workbook.createSheet();
		for(int i=1;i<10;i++){
			//String name = "row"+String.valueOf(i);
			XSSFRow row = sheet9.createRow(i);
			for(int j=1;j<=i;j++){
				int num = i*j;
				row.createCell(j).setCellValue(i+"*"+j+"="+num);
			}
		}		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		workbook.write(out);
		workbook.close();
		byte []data = out.toByteArray();
		return new ByteArrayInputStream(data);
	}
}
