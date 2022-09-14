package com.testing.testing.streamApi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class Employee {
    private String firstName;
    private String lastName;
    private Double salary;
    private List<String> project;
}
