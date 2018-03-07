package com.kavinaam.crm.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee_attendance")
public class Attendance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "month")
    private String month;

    @Column(name = "year")
    private String year;

    @Column(name = "working_days")
    private String workingDays;

    @Column(name = "present_days")
    private String presentDays;

    @Column(name = "attendance_certificate")
    private String attendanceCertificate;

    public Attendance() {
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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(String workingDays) {
        this.workingDays = workingDays;
    }

    public String getPresentDays() {
        return presentDays;
    }

    public void setPresentDays(String presentDays) {
        this.presentDays = presentDays;
    }

    public String getAttendanceCertificate() {
        return attendanceCertificate;
    }

    public void setAttendanceCertificate(String attendanceCertificate) {
        this.attendanceCertificate = attendanceCertificate;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", workingDays='" + workingDays + '\'' +
                ", presentDays='" + presentDays + '\'' +
                ", attendanceCertificate='" + attendanceCertificate + '\'' +
                '}';
    }
}
