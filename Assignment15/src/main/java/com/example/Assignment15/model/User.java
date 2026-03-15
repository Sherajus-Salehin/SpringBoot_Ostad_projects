package com.example.Assignment15.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Table(name="users")
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @NotNull
    private String userName;
    @NotNull
    private String password;
    private List<Note> notes;
    private List<String> roles;
}
