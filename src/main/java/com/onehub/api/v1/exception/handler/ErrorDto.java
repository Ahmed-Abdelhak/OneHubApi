package com.onehub.api.v1.exception.handler;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ErrorDto {
  String message;
  String code;
}
