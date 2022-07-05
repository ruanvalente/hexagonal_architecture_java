package com.example.hexagonal.adapter;

import com.example.hexagonal.domain.Employee;
import com.example.hexagonal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.hexagonal.port.EmployeeUIPort;

import java.util.List;

@RestController
@RequestMapping("/employees/")
public class EmployeeControllerAdapter implements EmployeeUIPort {
  @Autowired
  private EmployeeService employeeService;

  @Override
  public void create(@RequestBody Employee request) {
    employeeService.create(request.getName(), request.getRole(), request.getSalary());
  }

  @Override
  public Employee view(@PathVariable Integer id) {
    Employee employee = employeeService.view(id);
    return employee;
  }

  @Override
  public List<Employee> listAll() {
    List<Employee> employees = employeeService.listAll();
    return employees;
  }
}
