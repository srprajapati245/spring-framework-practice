package com.kavinaam.crm.daoimpl;

import com.kavinaam.crm.dao.DesignationDao;
import com.kavinaam.crm.entity.Designation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DesignationDaoImpl implements DesignationDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addOrUpdateDesignation(Designation designation) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(designation);
    }

    @Override
    public void deleteDesignation(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Designation where id = :ID");
        query.setParameter("ID", id);
        query.executeUpdate();
    }

    @Override
    public Designation getDesignationById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Designation.class, id);
    }

    @Override
    public Designation getDesignationByEmployee(Integer employeeId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Designation> designationQuery = session.createQuery("select d from Designation as d JOIN FETCH d.employee as e where e.id = :employeeId", Designation.class);
        designationQuery.setParameter("employeeId", employeeId);
        return designationQuery.getSingleResult();
    }
}
