package com.platzi.market.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "compras")
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer id;
    @Column(name = "id_cliente")
    private String idClient;
    @Column(name = "fecha")
    private LocalDateTime date;
    @Column(name = "medio_pago")
    private String paymentMeans;
    @Column(name = "comentario")
    private String comment;
    @Column(name = "estado")
    private boolean state;
    @ManyToOne()
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private ClientEntity clientEntity;
    @OneToMany(mappedBy = "purchaseEntity")
    private List<ProductPurchaseEntity> products;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMeans() {
        return paymentMeans;
    }

    public void setPaymentMeans(String paymentMeans) {
        this.paymentMeans = paymentMeans;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        PurchaseEntity purchaseEntity = (PurchaseEntity) o;
        return state == purchaseEntity.state && Objects.equals(id, purchaseEntity.id) && Objects.equals(idClient, purchaseEntity.idClient) && Objects.equals(date, purchaseEntity.date) && Objects.equals(paymentMeans, purchaseEntity.paymentMeans) && Objects.equals(comment, purchaseEntity.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idClient, date, paymentMeans, comment, state);
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", idClient='" + idClient + '\'' +
                ", date=" + date +
                ", paymentMeans='" + paymentMeans + '\'' +
                ", comment='" + comment + '\'' +
                ", state=" + state +
                '}';
    }
}