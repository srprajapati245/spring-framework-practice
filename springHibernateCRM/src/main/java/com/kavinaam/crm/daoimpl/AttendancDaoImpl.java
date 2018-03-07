package com.kavinaam.crm.daoimpl;

import com.kavinaam.crm.dao.AttendanceDao;
import com.kavinaam.crm.entity.Attendance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AttendancDaoImpl implements AttendanceDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addOrUpdateAttendance(Attendance attendance) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(attendance);
    }

    @Override
    public void deleteAttendance(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Attendance where id=:ID");
        query.setParameter("ID", id);
        query.executeUpdate();
    }

    @Override
    public Attendance getAttendanceById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Attendance.class, id);
    }

    @Override
    public List<Attendance> getAttendanceListByEmployee(Integer employeeId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Attendance> attendanceQuery = session.createQuery("select a from Attendance as a JOIN FETCH a.employee as e where e.id = :employeeId", Attendance.class);
        attendanceQuery.setParameter("employeeId", employeeId);
        return attendanceQuery.getResultList();
    }

    @Override
    public List<Attendance> getAttendanceListByEmployeeAndMonth(Integer employeeId, String month) {
        Session session = sessionFactory.getCurrentSession();
        Query<Attendance> attendanceQuery = session.createQuery("select a from Attendance as a JOIN FETCH a.employee as e where e.id = :employeeId and a.month = :month", Attendance.class);
        attendanceQuery.setParameter("employeeId", employeeId);
        attendanceQuery.setParameter("month", month);
        return attendanceQuery.getResultList();
    }

    @Override
    public List<Attendance> getAttendanceList() {
        Session session = sessionFactory.getCurrentSession();
        Query<Attendance> attendanceQuery = session.createQuery("from Attendance", Attendance.class);
        return attendanceQuery.getResultList();
    }
}
