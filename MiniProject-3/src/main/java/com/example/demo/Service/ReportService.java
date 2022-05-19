package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.EntityGen;
import com.example.demo.SearchRequest.SearchRequest;
import com.example.demo.SearchResponse.SearchResponse;


public interface ReportService {
	
	
	
	List<String> getAllPlanName();
	
	List<String> getAllPlanStatus();
	
	public List<SearchResponse> SearchPlans(SearchRequest request);

}
