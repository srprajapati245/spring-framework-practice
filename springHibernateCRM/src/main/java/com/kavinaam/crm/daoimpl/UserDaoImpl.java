package com.kavinaam.crm.daoimpl;

import com.kavinaam.crm.dao.UserDao;
import com.kavinaam.crm.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addOrUpdateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public void deleteUser(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from User where id=:ID");
        query.setParameter("ID", id);
        query.executeUpdate();
    }

    @Override
    public User getUserById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public User getEmployeeById(Integer employeeId) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> userQuery = session.createQuery("select u from User as u JOIN FETCH u.employee as e where e.id = :employeeId", User.class);
        userQuery.setParameter("employeeId", employeeId);
        return userQuery.getSingleResult();
    }

    @Override
    public List<User> getUserList() {
        Session session = sessionFactory.getCurrentSession();
        Query<User> userQuery = session.createQuery("from User", User.class);
        return userQuery.getResultList();
    }
}
