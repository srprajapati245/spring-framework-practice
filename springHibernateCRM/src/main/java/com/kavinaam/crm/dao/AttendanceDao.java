package com.kavinaam.crm.dao;

import com.kavinaam.crm.entity.Attendance;

import java.util.List;

public interface AttendanceDao {

    // Add or update attendance
    void addOrUpdateAttendance(Attendance attendance);

    // Delete attendance
    void deleteAttendance(Integer id);

    // Get attendance by id
    Attendance getAttendanceById(Integer id);

    // Get attendance list by employee for all months
    List<Attendance> getAttendanceListByEmployee(Integer employeeId);

    // Get attendance list by employee for perticular month
    List<Attendance> getAttendanceListByEmployeeAndMonth(Integer employeeId, String month);

    // Get all attendance list of all employee
    List<Attendance> getAttendanceList();

}