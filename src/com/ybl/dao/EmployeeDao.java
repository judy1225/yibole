package com.ybl.dao;

import java.util.List;

import com.ybl.vo.Employee;

public interface EmployeeDao {
	public List selectalluser();//��ѯ�����û�
	public void addUser(Employee user);//����û�
	public List selectuser(String xx);//������ѯ
	public void updateuser(Employee user);//�޸��û�
	public void deleteuser(Employee user);//ɾ���û�
	public Employee selectuserforId(String userId); 
  }     
