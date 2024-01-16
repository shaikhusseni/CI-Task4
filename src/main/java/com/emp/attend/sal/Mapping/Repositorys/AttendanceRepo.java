package com.emp.attend.sal.Mapping.Repositorys;

import com.emp.attend.sal.Mapping.Entitys.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AttendanceRepo extends JpaRepository<Attendance,Long> {
}
