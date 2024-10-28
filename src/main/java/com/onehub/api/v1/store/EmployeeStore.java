package com.onehub.api.v1.store;

import com.onehub.api.v1.model.EmployeeDto;
import jakarta.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmployeeStore {
  private Map<Integer, EmployeeDto> employees;
  private AtomicInteger idCounter;

  @PostConstruct
  public void init() {
    employees = new ConcurrentHashMap<>();
    idCounter = new AtomicInteger(0);
  }

  public Integer addEmployee(EmployeeDto employeeDto) {
    try {
      employees.put(idCounter.getAndAdd(1), employeeDto);
      return idCounter.get();
    } catch (Exception e) {
      log.error("Error adding employee", e);
      throw new RuntimeException("Error adding employee");
    }
  }

  public boolean isEmployeeExists(String email) {
    return employees.values().stream().anyMatch(e -> e.getEmail().equals(email));
  }
}
