package com.onehub.api.v1.controller;

import com.onehub.api.v1.exception.handler.BadRequestExceptionHandler;
import com.onehub.api.v1.exception.handler.ServerExceptionHandler;
import com.onehub.api.v1.model.EmployeeDto;
import com.onehub.api.v1.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/Employees")
public class EmployeesRestController implements BadRequestExceptionHandler, ServerExceptionHandler {

  private final EmployeeService employeeService;

  @PostMapping()
  @Operation(
      summary = "Add an employee",
      tags = {"Employees"},
      operationId = "addEmployee",
      responses = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "200",
            description = "Employee added successfully"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "400",
            description = "Invalid employee data")
      })
  public ResponseEntity<Integer> add(@RequestBody final EmployeeDto employeeDto) {
    return ResponseEntity.ok(employeeService.addEmployee(employeeDto));
  }
}
