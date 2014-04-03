package cc.test.questions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import cc.test.common.DateFormatCovert;
import cc.test.model.QuestionModel;
import cc.test.service.QuestionService;

@SuppressWarnings("serial")
public class ImportFileServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		QuestionService questionService=QuestionService.getIntance();
		
		String fileName=req.getParameter("files");
		File file = new File(getServletConfig().getServletContext().getRealPath("/")+"/file/"+fileName);
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));;
		List<List> datas = getDatasInSheet(workbook,0);

		for (int i = 0; i < datas.size(); i++) {// 读取数据
			//每一行数据
			List row = datas.get(i);
			
			QuestionModel question=new QuestionModel();
			question.setCode((Integer)row.get(0));
			question.setQuestion((String)row.get(1));
			question.setLevel((String)row.get(2));
			question.setTypeCode(String.valueOf(row.get(3)));
			question.setOptions((String)row.get(4));
			question.setRightAnswer((Integer)row.get(5));
			question.setTips((String)row.get(6));
			question.setImage((String)row.get(7));
			question.setSubject(String.valueOf(row.get(8)));
			
			questionService.insertQuestion(question);
		}
		
		//导入后，更新数据版本号，当前时间作为版本号
		questionService.updateHistoryCode(DateFormatCovert.dateTiemFormat(new Date()));
		
		resp.getWriter().println("Import qusetions succeed!");
		
	}
	
	/**
	* 获得表中的数据
	* @param sheetNumber 表格索引(EXCEL 是多表文档,所以需要输入表索引号)
	* @return 由LIST构成的行和表
	* @throws FileNotFoundException
	* @throws IOException
	*/
	public List<List> getDatasInSheet(HSSFWorkbook workbook,int sheetNumber) throws FileNotFoundException, IOException{
	   List<List> result = new ArrayList<List>();
	  
	   //获得指定的表
	   HSSFSheet sheet = workbook.getSheetAt(sheetNumber);
	  
	   //获得数据总行数
	   int rowCount = sheet.getLastRowNum();
	   if (rowCount < 2) {
	    return result;
	   }
	  
	   //逐行读取数据
	   for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
	   
	    //获得行对象
	    HSSFRow row = sheet.getRow(rowIndex);
	   
	    if (row != null) {
	    
	     List<Object> rowData = new ArrayList<Object>();
	    
	     //获得本行中单元格的个数
	     int columnCount = row.getLastCellNum();
	    
	     //获得本行中各单元格中的数据
	     for (short columnIndex = 0; columnIndex < columnCount; columnIndex++) {
	      HSSFCell cell = row.getCell(columnIndex);
	     
	      //获得指定单元格中数据
	      Object cellStr = this.getCellString(cell);
	     
	      rowData.add(cellStr);
	     
	     }
	    
	     result.add(rowData);
	    }
	   }
	   return result;
	}
	
	/**
	* 获得单元格中的内容
	* @param cell
	* @return
	*/
	protected Object getCellString(HSSFCell cell){
	   Object result = null;
	   if (cell != null) {

	    int cellType = cell.getCellType();
	   
	    switch(cellType){
	   
	    case HSSFCell.CELL_TYPE_STRING :
	     result = cell.getRichStringCellValue().getString();
	     break;
	    case HSSFCell.CELL_TYPE_NUMERIC:
	     result=(int)cell.getNumericCellValue();
	     break;
	    case HSSFCell.CELL_TYPE_FORMULA:
	     result = cell.getNumericCellValue();
	     break;
	    case HSSFCell.CELL_TYPE_ERROR:
	     result=null;
	     break;
	    case HSSFCell.CELL_TYPE_BOOLEAN:
	     result=cell.getBooleanCellValue();
	     break;
	    case HSSFCell.CELL_TYPE_BLANK:
	     result=null;
	     break;
	    }
	   }
	   return result;
	}
}
