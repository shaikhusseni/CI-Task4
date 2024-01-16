package com.emp.attend.sal.Mapping.Controllers;

import com.emp.attend.sal.Mapping.Dtos.EmployeeDto;
import com.emp.attend.sal.Mapping.Entitys.Employee;
import com.emp.attend.sal.Mapping.Services.AttendanceService;
import com.emp.attend.sal.Mapping.Services.EmployeeService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/employeeapi")
public class EmployeeController {


    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping("/save")
    public EmployeeDto saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return attendanceService.saveEmployee(employeeDto);
    }


}
