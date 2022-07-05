package com.example.hexagonal.adapter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.hexagonal.domain.Employee;
import com.example.hexagonal.port.EmployeeRepositoryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceAdapter implements EmployeeRepositoryPort {
  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
  @Override
  public void createEmployee(String name, String role, long salary) {
    Employee employee = new Employee();
    employee.setName(name);
    employee.setRole(role);
    employee.setSalary(salary);

    entityManager.persist(employee);
  }

  @Override
  public Employee getEmployeeById(Integer userId) {
    return entityManager.find(Employee.class, userId);
  }

  @Override
  public List listAllEmployees() {
    return entityManager.createNativeQuery("SELECT * from Employee",
            Employee.class).getResultList();
  }

  @Transactional
  @Override
  public boolean removeEmployee(Integer userId) {
    if (userId != null) {
      entityManager.createQuery("DELETE FROM Employee WHERE id = ?1")
              .setParameter(1, userId)
              .executeUpdate();
      entityManager.flush();

      return true;
    }
    return false;
  }
}
