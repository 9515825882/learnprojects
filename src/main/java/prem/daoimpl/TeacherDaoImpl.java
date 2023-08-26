package prem.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import prem.config.HibConfig;
import prem.dao.TeacherDao;
import prem.enties.Teacher;

public class TeacherDaoImpl implements TeacherDao{

	@Override
	public void add(Teacher teacher) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(teacher);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	}

	@Override
	public void delete(int tid) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Teacher teacher=(Teacher) session.get(Teacher.class, tid);
			session.delete(teacher);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	}

	@Override
	public List<Teacher> getAll() {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Query query=session.createQuery("select t from prem.enties.Teacher t");
		return query.list();
	}

}
