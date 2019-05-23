package com.kpi.markushevskiy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "warehouse", schema = "autoshop")
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    private Integer cost;

    @Column(name = "path_to_image")
    private String pathToImage;
}
