package com.example.demo.Service;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.EntityGen;
import com.example.demo.Repository.ReportRepository;
import com.example.demo.SearchRequest.SearchRequest;
import com.example.demo.SearchResponse.SearchResponse;


@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportRepository repo;
	
	@Override
	public List<String> getAllPlanName() {
	
		return repo.getAllPLANNAME();
	}

	@Override
	public List<String> getAllPlanStatus() {
		
		return repo.getAllPLANSTATUS();
	}

	@Override
	public List<SearchResponse> SearchPlans(SearchRequest request) {

		List<EntityGen> off = null;
		
		if(request == null) {
				off =repo.findAll();
		}
		else {
			String planName =request.getPlanName();
			String planStatus = request.getPlanStatus();
			LocalDate startDate = request.getStartDate();
			LocalDate endDate = request.getEndDate();
			
			EntityGen entity = new EntityGen();
			if(planName!= null && !planName.equals("")) {
				
				entity.getPlan_Name();
			}
			if(planStatus != null && !planStatus.equals(""))
			{
				entity.getPlan_Status();
			}
			if(startDate != null && endDate != null) {
				entity.getStart_Date();
				entity.getEnd_Date();
			}
		
			
			Example<EntityGen> of = Example.of(entity);
			
			off = repo.findAll(of);
		}
		
		List<SearchResponse> response = new ArrayList();
		for(EntityGen record:off) {
			SearchResponse sr = new SearchResponse();
			BeanUtils.copyProperties(off, response);
			response.add(sr);
		}
		
		return response;
	}

}
