package com.kavinaam.crm.daoimpl;

import com.kavinaam.crm.dao.EmployeeDao;
import com.kavinaam.crm.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addOrUpdateEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Employee where id = :ID");
        query.setParameter("ID", id);
        query.executeUpdate();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    @Override
    public List<Employee> getEmployeeByCompanyId(Integer companyId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> employeeQuery = session.createQuery("select e from Employee as e JOIN FETCH e.company as c where c.id = :companyId", Employee.class);
        employeeQuery.setParameter("companyId", companyId);
        return employeeQuery.getResultList();
    }

    @Override
    public List<Employee> getEmployeeList() {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> employeeQuery = session.createQuery("from Employee", Employee.class);
        return employeeQuery.getResultList();
    }
}