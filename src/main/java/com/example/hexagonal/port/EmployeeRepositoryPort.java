package com.example.hexagonal.port;

import com.example.hexagonal.domain.Employee;

import java.util.List;

public interface EmployeeRepositoryPort {
  void create(String name, String role, long salary);

  Employee getEmployee(Integer userId);

  List<Employee> listAllEmployee();
}
