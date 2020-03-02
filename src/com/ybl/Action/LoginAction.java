package com.ybl.Action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ybl.dao.LoginDao;
import com.ybl.dao.impl.LoginDaoImpl;
import com.ybl.vo.Admin;



public class LoginAction extends ActionSupport {	
	private Admin mid;
	private String message;	
	public String execute() throws Exception{
		//����DAO�ӿڶ���ͨ�����ýӿ��е�checkLogin����ʵ�ֵ�½��֤
	
		LoginDao loginDao=new LoginDaoImpl();
		
		Admin an=loginDao.checkLogin(mid.getId(), mid.getPasswd());
		System.out.println("123456");
		if(an!=null){				//�����½�ɹ�
		Map session=ActionContext.getContext().getSession();
			session.put("mid",1);	
			return SUCCESS;
			//��½�ɹ�����Ϣ������session��
		}else{
			return INPUT;			//��֤ʧ�ܷ���ERROR
		}
	}
	
	//��֤��¼���������Ƿ�Ϊ��
	public void validate(){
		if(mid.getId()==null||mid.getId().equals("")){
			this.addFieldError("mid.id","�û�������Ϊ��");
		}else if(mid.getPasswd()==null||mid.getPasswd().equals("")){
			this.addFieldError("mid.pwd", "���벻��Ϊ��");
		}
	}
	
	
	
	public Admin getMid() {
		return mid;
	}
	public void setMid(Admin mid) {
		this.mid = mid;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
