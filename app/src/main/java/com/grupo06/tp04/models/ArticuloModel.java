package com.grupo06.tp04.models;

import java.io.Serializable;

public class ArticuloModel implements Serializable {
    private Long id;
    private String nombre;
    private Integer stock;
    private Integer idCategoria;

    public ArticuloModel(){

    }

    public ArticuloModel(Long id, String nombre, Integer stock, Integer idCategoria) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.idCategoria = idCategoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

}


