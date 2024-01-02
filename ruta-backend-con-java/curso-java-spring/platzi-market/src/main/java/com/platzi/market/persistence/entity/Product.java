package com.platzi.market.persistence.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "productos")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "id_categoria")
    private Integer idCategory;
    @Column(name = "codigo_barra")
    private String barCode;
    @Column(name = "precio_venta")
    private Double salePrice;
    @Column(name = "cantidad_sto")
    private Integer inventoryQuality;
    @Column(name = "estado")
    private boolean state;
    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Category category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getInventoryQuality() {
        return inventoryQuality;
    }

    public void setInventoryQuality(Integer inventoryQuality) {
        this.inventoryQuality = inventoryQuality;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idCategory=" + idCategory +
                ", barCode='" + barCode + '\'' +
                ", salePrice=" + salePrice +
                ", inventoryQuality=" + inventoryQuality +
                ", state=" + state +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return state == product.state && Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(idCategory, product.idCategory) && Objects.equals(barCode, product.barCode) && Objects.equals(salePrice, product.salePrice) && Objects.equals(inventoryQuality, product.inventoryQuality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, idCategory, barCode, salePrice, inventoryQuality, state);
    }
}
