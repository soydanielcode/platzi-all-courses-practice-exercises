package com.platzi.market.persistence.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "compras_productos")
public class ProductPurchase {
    @Id
    @GeneratedValue
    @Column(name = "id_compra")
    private Integer id;
    @Column(name = "id_producto")
    private Integer idProduct;
    @Column(name = "cantidad")
    private Integer quantity;
    @Column(name = "total")
    private Double total;
    @Column(name = "estado")
    private boolean state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
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
        ProductPurchase that = (ProductPurchase) o;
        return state == that.state && Objects.equals(id, that.id) && Objects.equals(idProduct, that.idProduct) && Objects.equals(quantity, that.quantity) && Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idProduct, quantity, total, state);
    }

    @Override
    public String toString() {
        return "ProductPurchase{" +
                "id=" + id +
                ", idProduct=" + idProduct +
                ", quantity=" + quantity +
                ", total=" + total +
                ", state=" + state +
                '}';
    }
}
