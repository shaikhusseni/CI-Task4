package com.emp.attend.sal.Mapping.Services.ServiceImpl;

import com.emp.attend.sal.Mapping.Dtos.EmployeeDto;
import com.emp.attend.sal.Mapping.Entitys.Attendance;
import com.emp.attend.sal.Mapping.Entitys.Employee;
import com.emp.attend.sal.Mapping.Repositorys.AttendanceRepo;
import com.emp.attend.sal.Mapping.Repositorys.EmployeeRepo;
import com.emp.attend.sal.Mapping.Services.AttendanceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService {




        @Autowired
        private EmployeeRepo employeeRepository;
        @Autowired
        private AttendanceRepo attendanceRepository;
        @Autowired
        private ModelMapper modelMapper;

        @Override
        public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
            Employee employee = modelMapper.map(employeeDto, Employee.class);

            // Create Attendance objects for each AttendanceDto in the EmployeeDto
            List<Attendance> attendances = employeeDto.getAttendanceRecords().stream()
                    .map(attendanceDto -> modelMapper.map(attendanceDto, Attendance.class))
                    .collect(Collectors.toList());

            // Set the employee for each Attendance object
            attendances.forEach(attendance -> attendance.setEmployee(employee));

            // Save the Employee and Attendance objects
            employeeRepository.save(employee);
            attendanceRepository.saveAll(attendances);

            return modelMapper.map(employee, EmployeeDto.class);
        }
    }



