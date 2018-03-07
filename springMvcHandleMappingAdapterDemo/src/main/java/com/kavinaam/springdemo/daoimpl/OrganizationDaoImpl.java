package com.kavinaam.springdemo.daoimpl;

import com.kavinaam.springdemo.dao.OrganizationDao;
import com.kavinaam.springdemo.domain.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class OrganizationDaoImpl implements OrganizationDao  {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public boolean create(Organization organization) {
        SqlParameterSource beanParams = new BeanPropertySqlParameterSource(organization);
        String sqlQuery = "INSERT INTO organization (company_name, year_of_incorporation, postal_code, employee_count, slogan)" +
                "VALUES (:companyName, :yearOfIncorporation, :postalCode, :employeeCount, :slogan)";
        return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
    }

    public Organization getOrganization(Integer id) {
        String sqlQuery = "SELECT * FROM organization WHERE id = :ID";
        SqlParameterSource mapParams = new MapSqlParameterSource("ID", id);
        Organization organization = namedParameterJdbcTemplate.queryForObject(sqlQuery, mapParams, (ResultSet resultSet, int rowCount) -> {
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
        List<Organization> organizations = namedParameterJdbcTemplate.query(sqlQuery, (ResultSet resultSet, int rowCount) -> {
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
        SqlParameterSource beanParams = new BeanPropertySqlParameterSource(organization);
        String sqlQuery = "UPDATE organization SET slogan = :slogan WHERE id = :id";
        /*Object[] args = new Object[] {
            organization.getSlogan(),
            organization.getId()
        };*/
        return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
    }

    public boolean deleteOrganization(Integer id) {
        SqlParameterSource mapParams = new MapSqlParameterSource("ID", id);
        String sqlQuery = "DELETE FROM organization WHERE id = :ID";
        return namedParameterJdbcTemplate.update(sqlQuery, mapParams) == 1;
    }

    public void cleanup() {
        String sqlQuery = "TRUNCATE TABLE organization";
        namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery);
    }
}
