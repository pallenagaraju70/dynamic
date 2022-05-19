package com.example.demo.Rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Reports.ExcelGenerator;
import com.example.demo.Reports.PdfGenerator;
import com.example.demo.SearchRequest.SearchRequest;
import com.example.demo.SearchResponse.SearchResponse;
import com.example.demo.Service.ReportService;

@RestController
public class MyController {

	@Autowired
	private ReportService service;
	
	@GetMapping("/PlanName")
	public List<String> getPLAN_NAME(){
		
		return service.getAllPlanName();
	}
	
	@GetMapping("/PlanStatus")
	public List<String> getPLAN_STATUS(){
		
		return service.getAllPlanStatus();
	}
	
	@PostMapping("/search")
	public List<SearchResponse> Search(@RequestBody SearchRequest request){
		
		return service.SearchPlans(request);
	}
	
	@GetMapping("/Excel")
	public void generateExcel(HttpServletResponse response) throws Exception {
		
		response.setContentType("application/octet-stream");
		
		String headerkey = "Content-Disposition";
		String headervalue = "attachment; filename=Plans.xlsx";
		response.setHeader(headerkey, headervalue);
		
		List<SearchResponse> records = service.SearchPlans(null);
		
		ExcelGenerator excel = new ExcelGenerator();
		excel.generateExcel(records, response);
		
	}
	
	@GetMapping("/Pdf")
	public void generatePdf(HttpServletResponse httpresponse) throws Exception{
		
		httpresponse.setContentType("application/pdf");
		
		String headerkey = "Content-Disposition";
		String headervalue = "attachment; filename=plans.pdf";
		httpresponse.setHeader(headerkey, headervalue);
		
		List<SearchResponse> records = service.SearchPlans(null);
		PdfGenerator pdf = new PdfGenerator();
		
		pdf.generatepdf(records, httpresponse);
		
		
	}
}
