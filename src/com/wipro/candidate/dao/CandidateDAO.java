package com.wipro.candidate.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.wipro.candidate.bean.CandidateBean;
import com.wipro.candidate.util.DBUtil;

public class CandidateDAO {
	public String addCandidate(CandidateBean studentBean) {
		String status = "";
		try {
			/*write code here
			studentBean.getName();
			CandidateBean candidateBean = new CandidateBean();*/
			Statement result = DBUtil.getDBConn().createStatement();
			int total = result.executeUpdate("insert into EMPLOYEE values(\"" + studentBean.getId() + "\",\"" + studentBean.getName() + "\"," + studentBean.getM1() + "," + studentBean.getM2() + "," + studentBean.getM3() + ",\"" + studentBean.getResult() + "\",\"" + studentBean.getGrade() + "\")");
			if (total > 0) {
				status = "SUCCESS";
			}
			else status = "FAIL";
			//throw new SQLException("Fail");
		}
		catch (SQLException exception){
			return "FAIL";
		}
		return status;
	}



	public ArrayList<CandidateBean> getByResult(String criteria)
	{
		ArrayList<CandidateBean> list = new ArrayList<>();
		//write code here
		try{
			Statement result = DBUtil.getDBConn().createStatement();
			CandidateBean candidateBean = new CandidateBean();
			if(criteria == "PASS"){
				ResultSet resultSet = result.executeQuery("SELECT * from CANDIDATE_TBL where RESULT= "+ criteria);
				while (resultSet.next()){
					candidateBean.setId(resultSet.getString("id"));
					candidateBean.setName(resultSet.getString("name"));
					candidateBean.setM1(resultSet.getInt("m1"));
					candidateBean.setM2(resultSet.getInt("m2"));
					candidateBean.setM3(resultSet.getInt("m3"));
					candidateBean.setId(resultSet.getString("result"));
					candidateBean.setId(resultSet.getString("grade"));

					list.add(candidateBean);
				}
			}
			else if (criteria == "FAIL"){
				ResultSet resultSet = result.executeQuery("SELECT * from CANDIDATE_TBL where RESULT= "+ criteria);
				while (resultSet.next()){
					candidateBean.setId(resultSet.getString("id"));
					candidateBean.setName(resultSet.getString("name"));
					candidateBean.setM1(resultSet.getInt("m1"));
					candidateBean.setM2(resultSet.getInt("m2"));
					candidateBean.setM3(resultSet.getInt("m3"));
					candidateBean.setId(resultSet.getString("result"));
					candidateBean.setId(resultSet.getString("grade"));

					list.add(candidateBean);
				}
			}
			else if(criteria == "ALL"){
				ResultSet resultSet = result.executeQuery("SELECT * from CANDIDATE_TBL");
				while (resultSet.next()){
					candidateBean.setId(resultSet.getString("id"));
					candidateBean.setName(resultSet.getString("name"));
					candidateBean.setM1(resultSet.getInt("m1"));
					candidateBean.setM2(resultSet.getInt("m2"));
					candidateBean.setM3(resultSet.getInt("m3"));
					candidateBean.setId(resultSet.getString("result"));
					candidateBean.setId(resultSet.getString("grade"));

					list.add(candidateBean);
				}
			}
			else return null;
		}
		catch (SQLException e){
			return null;
		}
		return list;
	}



	public String generateCandidateId (String name)
	{
		String id="";
		//write code here
		String ch = name.substring(0,2).toUpperCase();
		id = ch + "1923";
		return id;
	}
}
