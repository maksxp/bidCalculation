package com.siaivo.bid.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
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
    @Column(name = "weight")
    @NotEmpty(message = "*Будь ласка вкажіть вагу")
    private Integer weight;
    @Column(name = "estimatedPrice")
    @NotEmpty(message = "*Будь ласка вкажіть ціну")
    private Integer estimatedPrice;
    @Column(name = "confirmedPrice")
    private Integer confirmedPrice;
    @Column(name = "product")
    private String product;
    @Column(name = "packingType")
    private String packingType;
    @Column(name = "currency")
    private String currency;
    @Column(name = "buyer")
    private String incoterms;
    @Column(name = "incoterms")
    private String buyer;
    @Column(name = "pallets")
    private Boolean pallets;
    @Column(name = "comment")
    private String comment;
    @Column(name = "destination")
    @NotEmpty(message = "*Будь ласка вкажіть місце поставки")
    private String destination;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public String getPackingType() {
        return packingType;
    }

    public void setPackingType(String packingType) {
        this.packingType = packingType;
    }

    public Boolean getPallets() {
        return pallets;
    }

    public void setPallets(Boolean pallets) {
        this.pallets = pallets;
    }

    public Integer getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(Integer estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public Integer getConfirmedPrice() {
        return confirmedPrice;
    }

    public void setConfirmedPrice(Integer confirmedPrice) {
        this.confirmedPrice = confirmedPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
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
