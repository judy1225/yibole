package com.ybl.dao;

import java.util.List;

import com.ybl.vo.Employer;


public interface EmployerDao {
	public List selectalluser();//��ѯ�����û�
	public void addUser(Employer user);//����û�
	public List selectuser(String xx);//������ѯ
	public void updateuser(Employer user);//�޸��û�
	public void deleteuser(Employer user);//ɾ���û�
  }     