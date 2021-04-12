package com.wipro.candidate.service;

import java.util.ArrayList;

import com.wipro.candidate.bean.CandidateBean;
import com.wipro.candidate.dao.CandidateDAO;
import com.wipro.candidate.helper.Helping;
import com.wipro.candidate.util.DBUtil;
import com.wipro.candidate.util.WrongDataException;

public class CandidateMain {

	public String addCandidate(CandidateBean candBean){
		String result="";
		String grade = "";
		String finalResponse="";
		try {
			Helping helping = new Helping();
			if (helping.checker()) {
				throw new WrongDataException();
			}
			CandidateDAO candidateDAO = new CandidateDAO();
			String val = candidateDAO.generateCandidateId(candBean.getName());
			candBean.setId(val);

			if(candBean.getM1()+candBean.getM2()+candBean.getM3()>=240){
				result = "PASS";
				grade = "Distinction";
			}
			else if(candBean.getM1()+candBean.getM2()+candBean.getM3()>=180 && candBean.getM1()+candBean.getM2()+candBean.getM3() < 240){
				result = "PASS";
				grade = "First class";
			}
			else if(candBean.getM1()+candBean.getM2()+candBean.getM3()>=150 && candBean.getM1()+candBean.getM2()+candBean.getM3() < 180){
				result = "PASS";
				grade = "Second class";
			}
			else if (candBean.getM1()+candBean.getM2()+candBean.getM3()>=105 && candBean.getM1()+candBean.getM2()+candBean.getM3() < 150){
				result = "PASS";
				grade = "Third class";
			}else {
				result = "FAIL";
				grade = "NO grade";
			}
			candBean.setResult(result);
			candBean.setGrade(grade);
			String response = candidateDAO.addCandidate(candBean);
			if (response == "SUCCESS") {
				finalResponse=String.format("%s:%s",val,result);
			}
			else {
				finalResponse="Error";
			}
		}catch (WrongDataException e){
			return "Data Incorrect";
		}
		return finalResponse;
	}
	public ArrayList<CandidateBean> displayAll(String criteria)
	{
		ArrayList<CandidateBean> candidateList = new ArrayList<>();
		CandidateDAO candidateDAO =new CandidateDAO();
		try{
			if(criteria !="PASS" || criteria != "FAIL" || criteria != "ALL"){
				throw new WrongDataException();
			}
			candidateList = candidateDAO.getByResult(criteria);
		}catch (WrongDataException e){
			return null;
		}
		return candidateList;
	}
	public static void main(String[] args) {
		//write code here
	}
}
