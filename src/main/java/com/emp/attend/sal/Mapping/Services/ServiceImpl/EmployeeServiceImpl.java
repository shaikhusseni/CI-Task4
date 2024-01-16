package com.emp.attend.sal.Mapping.Services.ServiceImpl;

import com.emp.attend.sal.Mapping.Dtos.EmployeeDto;
import com.emp.attend.sal.Mapping.Entitys.Employee;
import com.emp.attend.sal.Mapping.Repositorys.EmployeeRepo;
import com.emp.attend.sal.Mapping.Services.EmployeeService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmployeeRepo employeeRepo;

//    @Override
//    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
////        this is used to convert dto to enttiy
//
//        Employee savedEmployee=employeeRepo.save(convertDtoToEntity(employeeDto));
//
//        return mapEntityToDto(savedEmployee);
//    }


//    Related to Entitys to Dto and Dtos To Entity


    public Employee convertDtoToEntity(EmployeeDto employeeDto) {
        return modelMapper.map(employeeDto, Employee.class);
    }
    public EmployeeDto mapEntityToDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDto.class);
    }

}
