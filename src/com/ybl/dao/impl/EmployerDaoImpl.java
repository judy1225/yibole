package com.ybl.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ybl.dao.EmployerDao;
import com.ybl.util.HibernateSessionFactory;
import com.ybl.vo.Employer;

public class EmployerDaoImpl implements EmployerDao {
	//��ѯ������Ƹ����Ϣ
	public List selectalluser(){
		Session session=null;
		Transaction tx =null;
		List list=null;
		try{
			//��ûỰ
			session=HibernateSessionFactory.getSession();
			//��������
			tx=session.beginTransaction();
			//��ѯ��Ϣ
			Query query=session.createQuery("from Employer");
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

		public void addUser(Employer user) {  										//	����û�
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateSessionFactory.getSession();//��ûỰ
			tx=session.beginTransaction();//��������
			session.save(user);//�־û��������
			tx.commit();//�ύ����		
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	public List selectuser(String xx) {   									 // ��ѯ�û�
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		List list=null;
		try{
			session=HibernateSessionFactory.getSession();//��ûỰ
			tx=session.beginTransaction();//��������
			Query query=session.createQuery("from Employer where filmid=?");
			query.setParameter(0, xx);  
			/*query.setParameter(1, xx);
			query.setParameter(2, xx);*/
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

	public void updateuser(Employer user){					//�޸��û�
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateSessionFactory.getSession();//��ûỰ
			tx=session.beginTransaction();//��������	
			session.update(user);//
			tx.commit();//�ύ����		
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
	}	
	public void deleteuser(Employer user) { 			//ɾ���û�
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		System.out.println(user.getFilmid());
		try{
			session=HibernateSessionFactory.getSession();			//��ûỰ
			tx=session.beginTransaction();							//��������
			Query query=session.createQuery("delete Employer where filmid=?");
			query.setParameter(0,user.getFilmid());
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
