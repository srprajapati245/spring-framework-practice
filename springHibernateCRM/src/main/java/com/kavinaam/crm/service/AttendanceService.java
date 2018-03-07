package com.kavinaam.crm.service;

import com.kavinaam.crm.dao.AttendanceDao;
import com.kavinaam.crm.entity.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceDao attendanceDao;

    // Add or update attendance
    @Transactional
    public void addOrUpdateAttendance(Attendance attendance) {
        attendanceDao.addOrUpdateAttendance(attendance);
    }

    // Delete attendance
    @Transactional
    public void deleteAttendance(Integer id) {
        attendanceDao.deleteAttendance(id);
    }

    // Get attendance by id
    @Transactional
    public Attendance getAttendanceById(Integer id) {
        return attendanceDao.getAttendanceById(id);
    }

    // Get attendance list by employee for all months
    @Transactional
    public List<Attendance> getAttendanceListByEmployee(Integer employeeId) {
        return attendanceDao.getAttendanceListByEmployee(employeeId);
    }

    // Get attendance list by employee for perticular month
    @Transactional
    public List<Attendance> getAttendanceListByEmployeeAndMonth(Integer employeeId, String month) {
        return attendanceDao.getAttendanceListByEmployeeAndMonth(employeeId, month);
    }

    // Get all attendance list of all employee
    @Transactional
    public List<Attendance> getAttendanceList() {
        return attendanceDao.getAttendanceList();
    }

}
