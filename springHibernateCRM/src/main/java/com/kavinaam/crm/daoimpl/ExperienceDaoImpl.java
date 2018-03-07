package com.kavinaam.crm.daoimpl;

import com.kavinaam.crm.dao.ExperienceDao;
import com.kavinaam.crm.entity.Experience;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExperienceDaoImpl implements ExperienceDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addOrUpdateExperience(Experience experience) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(experience);
    }

    @Override
    public void deleteExperience(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Experience where id=:ID");
        query.setParameter("ID", id);
        query.executeUpdate();
    }

    @Override
    public Experience getExperienceById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Experience.class, id);
    }

    @Override
    public List<Experience> getExperienceListByEmployeeId(Integer employeeId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Experience> experienceQuery = session.createQuery("select ex from Experience as ex JOIN FETCH ex.employee as e where e.id = :employeeId", Experience.class);
        experienceQuery.setParameter("employeeId", employeeId);
        return experienceQuery.getResultList();
    }

    @Override
    public List<Experience> getExperienceList() {
        Session session = sessionFactory.getCurrentSession();
        Query<Experience> experienceQuery = session.createQuery("from Experience", Experience.class);
        return experienceQuery.getResultList();
    }
}
