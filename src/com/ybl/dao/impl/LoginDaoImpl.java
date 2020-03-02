package com.ybl.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ybl.dao.LoginDao;
import com.ybl.util.HibernateSessionFactory;
import com.ybl.vo.Admin;


public class LoginDaoImpl implements LoginDao{
	public Admin checkLogin(String m_id ,String m_pwd){
		Session session=null;
		Transaction tx=null;
		Admin mid=null;
		try{
			session=HibernateSessionFactory.getSession();//��ûỰ
			tx=session.beginTransaction();//��������
			Query query=session.createQuery("from Admin where id=?and passwd=?");
			query.setParameter(0,m_id);
			query.setParameter(1, m_pwd);
			mid=(Admin) query.uniqueResult();//ִ�в�ѯ
			tx.commit();//�ύ����
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}
		return mid;
	}

}
