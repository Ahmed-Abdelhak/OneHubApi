package com.onehub.api.v1.service;

import com.onehub.api.v1.model.EmployeeDto;
import com.onehub.api.v1.store.EmployeeStore;
import com.onehub.api.v1.validation.EmployeeValidator;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EmployeeServiceTest {

  private final EmployeeStore employeeStore = Mockito.mock(EmployeeStore.class);
  private final EmployeeValidator employeeValidator = Mockito.mock(EmployeeValidator.class);

  @Test
  void whenEmployeeDtoIsValidAndEmailIsUniqueThenReturnNewlyCreatedEmployeeId() {

    // given
    final var employeeDto = EmployeeDto.builder()
      .firstName("John")
      .surName("Doe")
      .address("1234, 5th Avenue")
      .title("Software Engineer")
      .gender("M")
      .dateOfBirth("01-01-1990")
      .email("John.Doe@gmail.com")
      .build();

    // when
    Mockito.when(employeeValidator.isValid(Mockito.any())).thenReturn(true);
    Mockito.when(employeeStore.isEmployeeExists(Mockito.any())).thenReturn(false);
    Mockito.when(employeeStore.addEmployee(Mockito.any())).thenReturn(1);

    // then
    var employeeService = new EmployeeService(employeeStore, employeeValidator);

    // assert
    Assert.assertThat(employeeService.addEmployee(employeeDto), CoreMatchers.is(1));
  }



  //TODO: Add more test cases
}
