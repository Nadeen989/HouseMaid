package com.example.housemaid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor @Data
public class ApiResponse {
    private String message;
    private Integer status;

    //private List<String> titles;
}
