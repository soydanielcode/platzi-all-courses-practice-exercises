package com.platzi.market.persistence.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "categorias")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "descripcion")
    private String description;
    @Column(name = "estado")
    private boolean state;
    @OneToMany(mappedBy = "categoryEntity")
    private List<ProductEntity> productEntities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return state == that.state && Objects.equals(id, that.id) && Objects.equals(description, that.description) && Objects.equals(productEntities, that.productEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, state, productEntities);
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", state=" + state +
                ", products=" + productEntities +
                '}';
    }
}
