package com.example.Assignment15.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.Data;

@Table(name = "tests")
@Entity
@Data
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String testString;

    public Test() {
    }
}
