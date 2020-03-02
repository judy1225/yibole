package com.ybl.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ybl.dao.ResumeDao;
import com.ybl.util.HibernateSessionFactory;
import com.ybl.vo.Resume;

public class ResumeDaoImpl implements ResumeDao {
	public List selectallresume(){
		Session session=null;
		Transaction tx =null;
		List list=null;
		try{
			//��ûỰ
			session=HibernateSessionFactory.getSession();
			//��������
			tx=session.beginTransaction();
			//��ѯ��Ϣ
			Query query=session.createQuery("from Resume");
//			query.setParameter(arg0, arg1)
			list=query.list();
			tx.commit();
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}

	public void deleteresume(Resume resume) {  //ɾ������
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		System.out.println(resume.getId());
		try{
			session=HibernateSessionFactory.getSession();			//��ûỰ
			tx=session.beginTransaction();							//��������
			Query query=session.createQuery("delete Resume where id=?");
			query.setParameter(0,resume.getId());
			query.executeUpdate();
			tx.commit();
		}catch(Exception e){
			if(tx!=null)
				tx.rollback();
				e.printStackTrace();
		}finally{
			session.close();
		}
	}


}
