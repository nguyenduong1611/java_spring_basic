package com.example.trainningspring.btvn.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true, length = 30)
    private String username;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(nullable = false)
    private String hoten;

    @Column(nullable = false)
    private String diachi;

    @Column(nullable = false)
    private String cccd;
}
