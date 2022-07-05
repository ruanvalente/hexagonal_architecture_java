package com.example.hexagonal.service;

import com.example.hexagonal.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hexagonal.port.EmployeeRepositoryPort;

import java.util.List;

@Service
public class EmployeeService {
  @Autowired
  private EmployeeRepositoryPort employeeRepository;

  public void create(String name, String role, long salary) {
    employeeRepository.create(name, role, salary);
  }

  public Employee view(Integer userId) {
    return employeeRepository.getEmployee(userId);
  }

  public List<Employee> listAll() {
    return employeeRepository.listAllEmployee();
  }
}
