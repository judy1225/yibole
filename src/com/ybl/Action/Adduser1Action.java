package com.ybl.Action;

import com.opensymphony.xwork2.ActionSupport;
import com.ybl.dao.EmployerDao;
import com.ybl.dao.impl.EmployerDaoImpl;
import com.ybl.vo.Employer;



public class Adduser1Action extends ActionSupport {
	private String message;
	private Employer employer;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	
	EmployerDao employerdao=new EmployerDaoImpl();
	public String addUser() throws Exception{
//		Employer em=employerdao.selectuser();
//		if(bo!=null){  //�жϸ��û��Ƿ����
//			this.setMessage("���û����Ѵ���");
//			
//		}
		Employer eme=new Employer();
		eme.setFilmid(employer.getFilmid());
		eme.setFirmpwd(employer.getFirmpwd());
		eme.setPlace(employer.getPlace());
		eme.setFilmnum(employer.getFilmnum());
		employerdao.addUser(eme);
		this.setMessage("��ӳɹ�");
		System.out.println(employer.getFilmid());
		return SUCCESS;
		
	}
}
