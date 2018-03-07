package com.kavinaam.crm.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee_education")
public class Education implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "stream")
    private String stream;

    @Column(name = "stream_category")
    private String streamCategory;

    @Column(name = "percentage")
    private String percentage;

    @Column(name = "certificate")
    private String certificate;

    public Education() {
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

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getStreamCategory() {
        return streamCategory;
    }

    public void setStreamCategory(String streamCategory) {
        this.streamCategory = streamCategory;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", stream='" + stream + '\'' +
                ", streamCategory='" + streamCategory + '\'' +
                ", percentage='" + percentage + '\'' +
                ", certificate='" + certificate + '\'' +
                '}';
    }
}
