package com.kpi.markushevskiy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users", schema = "autoshop")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_role")
    private Role role;

    private Boolean enabled;

}
