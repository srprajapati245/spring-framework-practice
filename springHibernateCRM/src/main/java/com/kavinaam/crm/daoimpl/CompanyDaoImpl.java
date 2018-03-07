package com.kavinaam.crm.daoimpl;


import com.kavinaam.crm.dao.CompanyDao;
import com.kavinaam.crm.entity.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyDaoImpl implements CompanyDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addOrUpdateCompany(Company company) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(company);
    }

    @Override
    public void deleteCompany(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query companyQuery = session.createQuery("delete from Company where id=:ID");
        companyQuery.setParameter("ID", id);
        companyQuery.executeUpdate();
    }

    @Override
    public Company getCompanyById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Company.class, id);
    }

    @Override
    public List<Company> getCompanyList() {
        Session session = sessionFactory.getCurrentSession();
        Query<Company> companyQuery = session.createQuery("from Company", Company.class);
        return companyQuery.getResultList();
    }
}
