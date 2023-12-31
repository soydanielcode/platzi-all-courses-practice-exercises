package com.platzi.market.persistence.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "compras_productos")
public class ProductPurchase {
    @EmbeddedId
    private ProductPurchasePk id;
    @Column(name = "cantidad")
    private Integer quantity;
    @Column(name = "total")
    private Double total;
    @Column(name = "estado")
    private boolean state;

    public ProductPurchasePk getId() {
        return id;
    }

    public void setId(ProductPurchasePk id) {
        this.id = id;
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
        return state == that.state && Objects.equals(id, that.id) && Objects.equals(quantity, that.quantity) && Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, total, state);
    }

    @Override
    public String toString() {
        return "ProductPurchase{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", total=" + total +
                ", state=" + state +
                '}';
    }
}
