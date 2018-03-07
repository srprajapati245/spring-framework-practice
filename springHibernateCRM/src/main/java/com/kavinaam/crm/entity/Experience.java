package com.kavinaam.crm.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee_previous_experiance")
public class Experience implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "previous_company_name")
    private String companyName;

    @Column(name = "post")
    private String designation;

    @Column(name = "from_month_year")
    private String fromMonthYear;

    @Column(name = "to_month_year")
    private String  toMonthYear;

    public Experience() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getFromMonthYear() {
        return fromMonthYear;
    }

    public void setFromMonthYear(String fromMonthYear) {
        this.fromMonthYear = fromMonthYear;
    }

    public String getToMonthYear() {
        return toMonthYear;
    }

    public void setToMonthYear(String toMonthYear) {
        this.toMonthYear = toMonthYear;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", designation='" + designation + '\'' +
                ", fromMonthYear='" + fromMonthYear + '\'' +
                ", toMonthYear='" + toMonthYear + '\'' +
                '}';
    }
}
