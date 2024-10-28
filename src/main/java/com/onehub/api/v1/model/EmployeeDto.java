package com.onehub.api.v1.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class EmployeeDto {
  String title;
  String firstName;
  String surName;
  String dateOfBirth; // YYYY-MM-DD  //TODO: re-visit or Use LocalDate
  String address;
  String gender;
  String email;
}
