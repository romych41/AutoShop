package com.kpi.markushevskiy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orders", schema = "autoshop")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    private String owner;

    @Column(name = "ids_of_details")
    private String details;
}
