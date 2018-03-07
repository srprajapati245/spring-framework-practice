package com.kavinaam.crm.daoimpl;

import com.kavinaam.crm.dao.CustomerDao;
import com.kavinaam.crm.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> customerQuery = session.createQuery("from Customer order by lastName", Customer.class);

        return customerQuery.getResultList();
    }

    @Override
    public void updateCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.update(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query customerQuery = session.createQuery("delete from Customer where id=:ID");
        customerQuery.setParameter("ID", id);
        customerQuery.executeUpdate();
    }
}
