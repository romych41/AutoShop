package com.kpi.markushevskiy.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "baskets", schema = "autoshop")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String owner;

    @Column(name = "ids_of_details")
    private String details;
}
