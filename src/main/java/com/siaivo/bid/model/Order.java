package com.siaivo.bid.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
@Table(name = "request")
public class Order {

    @Column(name = "status")
    private String status;
    @Id
    @Column(name = "request_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "creation_date")
    private Date startDate;
    @Column(name = "approve_date")
    private Date approveDate;
    @Column(name = "close_date")
    private Date closeDate;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "product")
    private String product;
    @Column(name = "buyer")
    private String incoterms;
    @Column(name = "incoterms")
    private String buyer;
    @Column(name = "comment")
    private String comment;
    @Column(name = "destination")
    @NotEmpty(message = "*Будь ласка вкажіть місце поставки")
    private String destination;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getProduct() { return product;}

    public void setProduct(String product) {
        this.product = product;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getIncoterms() {
        return incoterms;
    }

    public void setIncoterms(String incoterms) {
        this.incoterms = incoterms;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }
    @Override
    public int hashCode() {
        return id;
    }
}
