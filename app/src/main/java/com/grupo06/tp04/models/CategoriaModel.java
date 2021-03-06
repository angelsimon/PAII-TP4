package com.grupo06.tp04.models;

import java.io.Serializable;

public class CategoriaModel implements Serializable {
    private Integer id;
    private String descripcion;

    public CategoriaModel(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public CategoriaModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "CategoriaModel{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
