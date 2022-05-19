package com.example.demo.SearchResponse;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SearchResponse {

	private Integer plan_Id ;
	private Long case_Num;
	private String plan_Name;
	private String plan_Status;
	private String holder_Name;
	private String holder_Ssn;
	private double benefit_Amt;
	private LocalDate Start_Date;
	private LocalDate End_Date;
	private String denied_Reason;
	
	
	public Integer getPlan_Id() {
		return plan_Id;
	}
	public void setPlan_Id(Integer plan_Id) {
		this.plan_Id = plan_Id;
	}
	public Long getCase_Num() {
		return case_Num;
	}
	public void setCase_Num(Long case_Num) {
		this.case_Num = case_Num;
	}
	public String getPlan_Name() {
		return plan_Name;
	}
	public void setPlan_Name(String plan_Name) {
		this.plan_Name = plan_Name;
	}
	public String getPlan_Status() {
		return plan_Status;
	}
	public void setPlan_Status(String plan_Status) {
		this.plan_Status = plan_Status;
	}
	public String getHolder_Name() {
		return holder_Name;
	}
	public void setHolder_Name(String holder_Name) {
		this.holder_Name = holder_Name;
	}
	public String getHolder_Ssn() {
		return holder_Ssn;
	}
	public void setHolder_Ssn(String holder_Ssn) {
		this.holder_Ssn = holder_Ssn;
	}
	public double getBenefit_Amt() {
		return benefit_Amt;
	}
	public void setBenefit_Amt(double benefit_Amt) {
		this.benefit_Amt = benefit_Amt;
	}
	public LocalDate getStart_Date() {
		return Start_Date;
	}
	public void setStart_Date(LocalDate start_Date) {
		Start_Date = start_Date;
	}
	public LocalDate getEnd_Date() {
		return End_Date;
	}
	public void setEnd_Date(LocalDate end_Date) {
		End_Date = end_Date;
	}
	public String getDenied_Reason() {
		return denied_Reason;
	}
	public void setDenied_Reason(String denied_Reason) {
		this.denied_Reason = denied_Reason;
	}
	
	
	
	
}
