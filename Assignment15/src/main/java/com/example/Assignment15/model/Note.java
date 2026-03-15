package com.example.Assignment15.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Table(name = "notes")
@Entity
@Data
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String content;
    @NotNull
    private String ownerUsername;
}
