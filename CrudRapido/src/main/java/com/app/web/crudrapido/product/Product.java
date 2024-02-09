package com.app.web.crudrapido.product;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;



@Entity
@Table
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nombre;

    private float precio;
    private LocalDate fecha;

    @Transient
    private int antiguedad;

    public Product() {

    }

    public Product(Long id, String nombre, float precio, LocalDate fecha) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fecha = fecha;

    }

    public Product(String nombre, float precio, LocalDate fecha) {
        this.nombre = nombre;
        this.precio = precio;
        this.fecha = fecha;

    }


}
