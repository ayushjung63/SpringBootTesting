package com.ayush.testing.utils;

import com.ayush.testing.enums.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GlobalApiResponse {
    private ResponseStatus status;
    private String message;
    private Object data;
}
