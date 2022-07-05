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
  public void createEmployee(@RequestBody Employee request) {
    employeeService.createEmployee(request.getName(), request.getRole(),
            request.getSalary());
  }

  @Override
  public Employee getEmployeeById(@PathVariable Integer id) {
    return employeeService.getEmployeeById(id);
  }

  @Override
  public List<Employee> listAllEmployees() {
    return employeeService.listAllEmployees();
  }

  @Override
  public void removeEmployee(@PathVariable Integer id) {
     employeeService.removeEmployee(id);
  }
}
