package com.onehub.api.v1.service;

import com.onehub.api.v1.model.EmployeeDto;
import com.onehub.api.v1.store.EmployeeStore;
import com.onehub.api.v1.validation.EmployeeValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

  private final EmployeeStore employeeStore;
  private final EmployeeValidator employeeValidator;

  public Integer addEmployee(EmployeeDto employeeDto) {
    if (employeeValidator.isValid(employeeDto)) {
      if (hasDuplicateEmail(employeeDto)) {
        throw new IllegalArgumentException(
            "Employee with email already exists"); // TODO: Add a custom exception and handle it
        // with a proper exception message
      }
      return employeeStore.addEmployee(employeeDto);
    } else {
      throw new IllegalArgumentException(
          "Invalid employee"); // TODO: Add a custom exception and handle it with a proper exception
      // message
    }
  }

  private boolean hasDuplicateEmail(EmployeeDto employeeDto) {
    return employeeStore.isEmployeeExists(employeeDto.getEmail());
  }
}
