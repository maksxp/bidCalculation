package com.siaivo.bid.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "buyer")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="buyer_id")
    private int id;

    @Column(name="name")
    @NotEmpty(message = "*Будь ласка вкажіть назву покупця")
    private String name;

    @NotEmpty(message = "*Будь ласка вкажіть країну розташування покупця")
    private String country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name="country")

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Buyer buyer = (Buyer) o;

        return id == buyer.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
