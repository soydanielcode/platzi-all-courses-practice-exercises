package com.platzi.market.persistence.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "clientes")
public class Client {
    @Id
    private String id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "apellidos")
    private String lastName;
    @Column(name = "celular")
    private Double cellphone;
    @Column(name = "correo_electronico")
    private String mail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getCellphone() {
        return cellphone;
    }

    public void setCellphone(Double cellphone) {
        this.cellphone = cellphone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name) && Objects.equals(lastName, client.lastName) && Objects.equals(cellphone, client.cellphone) && Objects.equals(mail, client.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, cellphone, mail);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cellphone=" + cellphone +
                ", mail='" + mail + '\'' +
                '}';
    }
}
