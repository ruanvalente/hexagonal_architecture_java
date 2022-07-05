package com.example.hexagonal.port;

import com.example.hexagonal.domain.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EmployeeUIPort {
  @PostMapping("create")
  public void create(@RequestBody Employee request);

  @GetMapping("view/{id}")
  Employee view(@PathVariable Integer userId);

  @GetMapping("list")
  List<Employee> listAll();
}
