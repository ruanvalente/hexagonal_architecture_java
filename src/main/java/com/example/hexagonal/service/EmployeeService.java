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

  public void createEmployee(String name, String role, long salary) {
    employeeRepository.createEmployee(name, role, salary);
  }

  public Employee getEmployeeById(Integer userId) {
    return employeeRepository.getEmployeeById(userId);
  }

  public List<Employee> listAllEmployees() {
    return employeeRepository.listAllEmployees();
  }

  public boolean removeEmployee(Integer userId) {
    return employeeRepository.removeEmployee(userId);
  }
}
