package com.kavinaam.crm.daoimpl;

import com.kavinaam.crm.dao.EducationDao;
import com.kavinaam.crm.entity.Education;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EducationDaoImpl implements EducationDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addOrUpdateEducation(Education education) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(education);
    }

    @Override
    public void deleteEducation(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Education where id = :ID");
        query.setParameter("ID", id);
        query.executeUpdate();
    }

    @Override
    public Education getEducationById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Education.class, id);
    }

    @Override
    public List<Education> getEducationListByEmployee(Integer employeeId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Education> educationQuery = session.createQuery("select ed from Education as ed JOIN FETCH ed.employee as e where e.id = :employeeId", Education.class);
        educationQuery.setParameter("employeeId", employeeId);
        return educationQuery.getResultList();
    }
}
