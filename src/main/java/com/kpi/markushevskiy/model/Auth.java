package com.kpi.markushevskiy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "authorities", schema = "autoshop")
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String authority;
}
