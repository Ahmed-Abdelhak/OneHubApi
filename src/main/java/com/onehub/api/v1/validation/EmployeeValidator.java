package com.onehub.api.v1.validation;

import com.onehub.api.v1.model.EmployeeDto;
import org.springframework.stereotype.Component;

@Component
public class EmployeeValidator {

  public boolean isValid(EmployeeDto employeeDto) {
    return employeeDto != null
        && !employeeDto.getFirstName().isEmpty()
        && !employeeDto.getSurName().isEmpty()
        && !employeeDto.getDateOfBirth().isEmpty()
        && !employeeDto.getEmail().isEmpty();
  }
}
