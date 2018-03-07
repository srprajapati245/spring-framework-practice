package com.kavinaam.springdemo.daoimpl;

import com.kavinaam.springdemo.dao.OrganizationDao;
import com.kavinaam.springdemo.domain.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

//@Repository("myOrg")
public class OrganizationDaoImpl implements OrganizationDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource ds) {
        jdbcTemplate = new JdbcTemplate(ds);
    }

    public boolean create(Organization organization) {
        String sqlQuery = "INSERT INTO organization (company_name, year_of_incorporation, postal_code, employee_count, slogan)" +
                "VALUES (?, ?, ?, ?, ?)";
        Object[] args = new Object[] {
                organization.getCompanyName(),
                organization.getYearOfIncorporation(),
                organization.getPostalCode(),
                organization.getEmployeeCount(),
                organization.getSlogan()
        };
        return jdbcTemplate.update(sqlQuery, args) == 1;
    }

    public Organization getOrganization(Integer id) {
        String sqlQuery = "SELECT * FROM organization WHERE id = ?";
        Object[] args = new Object[] {id};
        Organization organization = jdbcTemplate.queryForObject(sqlQuery, args, (ResultSet resultSet, int rowCount) -> {
            Organization org = new Organization();
            org.setId(resultSet.getInt("id"));
            org.setCompanyName(resultSet.getString("company_name"));
            org.setYearOfIncorporation(resultSet.getInt("year_of_incorporation"));
            org.setEmployeeCount(resultSet.getInt("employee_count"));
            org.setPostalCode(resultSet.getString("postal_code"));
            org.setSlogan(resultSet.getString("slogan"));

            return  org;
        });
        return organization;
    }

    public List<Organization> getAllOrganization() {

        String sqlQuery = "SELECT * FROM organization";
        List<Organization> organizations = jdbcTemplate.query(sqlQuery, (ResultSet resultSet, int rowCount) -> {
            Organization organization = new Organization();
            organization.setId(resultSet.getInt("id"));
            organization.setCompanyName(resultSet.getString("company_name"));
            organization.setYearOfIncorporation(resultSet.getInt("year_of_incorporation"));
            organization.setEmployeeCount(resultSet.getInt("employee_count"));
            organization.setPostalCode(resultSet.getString("postal_code"));
            organization.setSlogan(resultSet.getString("slogan"));

            return  organization;
        });

        return organizations;
    }

    public boolean updateOrganization(Organization organization) {
        String sqlQuery = "UPDATE organization SET slogan = ? WHERE id = ?";
        Object[] args = new Object[] {
            organization.getSlogan(),
            organization.getId()
        };
        return jdbcTemplate.update(sqlQuery, args) == 1;
    }

    public boolean deleteOrganization(Integer id) {
        String sqlQuery = "DELETE FROM organization WHERE id = ?";
        Object[] args = new Object[] {id};
        return jdbcTemplate.update(sqlQuery, args) == 1;
    }

    public void cleanup() {
        String sqlQuery = "TRUNCATE TABLE organization";
        jdbcTemplate.execute(sqlQuery);
    }
}
