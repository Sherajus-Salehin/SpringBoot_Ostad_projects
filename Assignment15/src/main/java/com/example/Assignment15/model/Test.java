package com.example.Assignment15.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Table(name="tests")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private @NotNull String testString;

}
