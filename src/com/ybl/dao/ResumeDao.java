package com.ybl.dao;

import java.util.List;

import com.ybl.vo.Employee;
import com.ybl.vo.Resume;

public interface ResumeDao {
	public List selectallresume();//��ѯ���м���
	public void deleteresume(Resume resume );//ɾ������
}
