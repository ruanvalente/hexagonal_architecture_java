package com.example.hexagonal.port;

import com.example.hexagonal.domain.Employee;

import java.util.List;

public interface EmployeeRepositoryPort {
  void createEmployee(String name, String role, long salary);

  Employee getEmployeeById(Integer userId);

  List<Employee> listAllEmployees();

  boolean removeEmployee(Integer userId);
}
