package com.example.demo.Reports;

import java.awt.Color;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.SearchResponse.SearchResponse;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfGenerator {
	
	public void generatepdf(List<SearchResponse> response, HttpServletResponse httpResponse) throws Exception {
		
		 Document document = new Document();
		 
		 PdfWriter writer= PdfWriter.getInstance(document, httpResponse.getOutputStream());
		 
		 document.open();
		 
		 Font font = new Font(Font.BOLDITALIC, 16, Font.NORMAL, Color.DARK_GRAY);
	      Paragraph para = new Paragraph("EntityGen", font);
	      
	      writer.add(para);
	      
	      PdfPTable pdf = new PdfPTable(9);
	      
	      pdf.addCell("S.No");
	      
	      pdf.addCell("Holder Name");
	      
	      pdf.addCell("Holder SSN");
	      
	      pdf.addCell("Plan Name");
	      
	      pdf.addCell("Plan Status");
	      
	      pdf.addCell("Benefit Amount");
	      
	      pdf.addCell("Start Date");
	      
	      pdf.addCell("End Date");
	      
	      pdf.addCell("Denial Reason");
	      
	      
	     int sno =1;
	     for(SearchResponse record: response) 
	     {
	    
	    	 pdf.addCell(String.valueOf(sno));
	    	 
	    	 pdf.addCell(record.getHolder_Name());
	    	 
	    	 pdf.addCell(String.valueOf(record.getHolder_Ssn()));
	    	 
	    	 pdf.addCell(record.getPlan_Name());
	    	 
	    	 pdf.addCell(record.getPlan_Status());
	    	 
	    	 pdf.addCell(String.valueOf(record.getBenefit_Amt()));
	    	 
	    	 pdf.addCell(String.valueOf(record.getStart_Date()));
	    	 
	    	 pdf.addCell(String.valueOf(record.getEnd_Date()));
	    	 
	    	 pdf.addCell(record.getDenied_Reason());
	    	 
	    	 sno++;
	     }
	      
	      document.add(pdf);  
	      writer.close();

}
}
