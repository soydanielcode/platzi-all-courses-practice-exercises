package com.platzi.market.persistence.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "productos")
public class ProductEntity {
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
    private CategoryEntity categoryEntity;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return state == that.state && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(idCategory, that.idCategory) && Objects.equals(barCode, that.barCode) && Objects.equals(salePrice, that.salePrice) && Objects.equals(inventoryQuality, that.inventoryQuality) && Objects.equals(categoryEntity, that.categoryEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, idCategory, barCode, salePrice, inventoryQuality, state, categoryEntity);
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idCategory=" + idCategory +
                ", barCode='" + barCode + '\'' +
                ", salePrice=" + salePrice +
                ", inventoryQuality=" + inventoryQuality +
                ", state=" + state +
                ", categoryEntity=" + categoryEntity +
                '}';
    }
}
