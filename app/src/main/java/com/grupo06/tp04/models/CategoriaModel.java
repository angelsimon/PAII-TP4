package com.grupo06.tp04.models;

import java.io.Serializable;

public class CategoriaModel implements Serializable {
    private Long id;
    private String descripcion;

    public CategoriaModel(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public CategoriaModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
