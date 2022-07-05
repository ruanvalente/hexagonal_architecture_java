package com.example.hexagonal.port;

import com.example.hexagonal.domain.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface EmployeeUIPort {
  @PostMapping("create")
  public void createEmployee(@RequestBody Employee request);

  @GetMapping("view/{id}")
  Employee getEmployeeById(@PathVariable Integer userId);

  @GetMapping("list")
  List<Employee> listAllEmployees();

  @DeleteMapping("remove/{id}")
  void removeEmployee(@PathVariable Integer id);
}
