package com.ybl.Action;

import com.opensymphony.xwork2.ActionSupport;
import com.ybl.dao.EmployeeDao;
import com.ybl.dao.impl.EmployeeDaoImpl;
import com.ybl.vo.Employee;

public class AdduserAction extends ActionSupport{
	private String message;
	private Employee employee;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	EmployeeDao employeedao=new EmployeeDaoImpl();
	public String addUser() throws Exception{
//		Employee em=employeedao.selectuser();
//		if(bo!=null){  //�жϸ��û��Ƿ����
//			this.setMessage("���û����Ѵ���");
//			
//		}
		Employee eme=new Employee();
		eme.setRealname(employee.getRealname());
		eme.setUsername(employee.getUsername());
		eme.setUserpwd(employee.getUserpwd());
		eme.setUsernum(employee.getUsernum());
		eme.setEmail(employee.getEmail());
		eme.setSex(employee.getSex());
		employeedao.addUser(eme);
		this.setMessage("��ӳɹ�");
		System.out.println(employee.getEmail());
		return SUCCESS;
		
	}
}
