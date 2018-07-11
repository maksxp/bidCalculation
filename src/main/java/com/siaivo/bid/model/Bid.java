package com.siaivo.bid.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "bid")
public class Bid {

    @Column(name = "status")
    private String status;
    @Id
    @Column(name = "BidId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bidId;
    @Column(name = "creationDate")
    private Date creationDate;
    @Column(name = "approveDate")
    private Date approveDate;
    @Column(name = "productReleaseMonth")
    private Integer productReleaseMonth;
    @Column(name = "productReleaseYear")
    private Integer productReleaseYear;
    @Column(name = "weightForSale")
    @NotNull(message = "*Будь ласка вкажіть вагу")
    @Min(value = 1, message = "Вага має бути не нуль")
    private Integer weightForSale;
    @Column(name = "purityForSale")
    @NotNull(message = "*Будь ласка вкажіть чистоту")
    private Float purityForSale;
    @Column(name = "humidityForSale")
    @NotNull(message = "*Будь ласка вкажіть вологість")
    private Float humidityForSale;
    @Column(name = "estimatedSalePrice")
    @NotNull(message = "*Будь ласка вкажіть ціну")
    @Min(100)
    private Integer estimatedSalePrice;
    @Column(name = "confirmedSalePrice")
    private Integer confirmedSalePrice;
    @Column(name = "product")
    private String product;
    @Column(name = "packingTypeForSale")
    private String packingTypeForSale;
    @Column(name = "saleCurrency")
    private String saleCurrency;
    @Column(name = "buyer")
    private String incoterms;
    @Column(name = "incoterms")
    private String buyer;
    @Column(name = "pallets")
    private Boolean pallets;
    @Column(name = "comment")
    private String comment;
    @Column(name = "destinationPlace")
    @NotEmpty(message = "*Будь ласка вкажіть місце поставки")
    private String destinationPlace;
    @Column(name = "destinationCountry")
    @NotEmpty(message = "*Будь ласка вкажіть країну поставки")
    private String destinationCountry;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Bid() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBidId() {
        return bidId;
    }

    public void setBidId(int bidId) {
        this.bidId = bidId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public Integer getProductReleaseMonth() {
        return productReleaseMonth;
    }

    public void setProductReleaseMonth(Integer productReleaseMonth) {
        this.productReleaseMonth = productReleaseMonth;
    }

    public Integer getProductReleaseYear() {
        return productReleaseYear;
    }

    public void setProductReleaseYear(Integer productReleaseYear) {
        this.productReleaseYear = productReleaseYear;
    }

    public Integer getWeightForSale() {
        return weightForSale;
    }

    public void setWeightForSale(Integer weightForSale) {
        this.weightForSale = weightForSale;
    }

    public Float getPurityForSale() {
        return purityForSale;
    }

    public void setPurityForSale(Float purityForSale) {
        this.purityForSale = purityForSale;
    }

    public Float getHumidityForSale() {
        return humidityForSale;
    }

    public void setHumidityForSale(Float humidityForSale) {
        this.humidityForSale = humidityForSale;
    }

    public Integer getEstimatedSalePrice() {
        return estimatedSalePrice;
    }

    public void setEstimatedSalePrice(Integer estimatedSalePrice) {
        this.estimatedSalePrice = estimatedSalePrice;
    }

    public Integer getConfirmedSalePrice() {
        return confirmedSalePrice;
    }

    public void setConfirmedSalePrice(Integer confirmedSalePrice) {
        this.confirmedSalePrice = confirmedSalePrice;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getPackingTypeForSale() {
        return packingTypeForSale;
    }

    public void setPackingTypeForSale(String packingTypeForSale) {
        this.packingTypeForSale = packingTypeForSale;
    }

    public String getSaleCurrency() {
        return saleCurrency;
    }

    public void setSaleCurrency(String saleCurrency) {
        this.saleCurrency = saleCurrency;
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

    public Boolean getPallets() {
        return pallets;
    }

    public void setPallets(Boolean pallets) {
        this.pallets = pallets;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDestinationPlace() {
        return destinationPlace;
    }

    public void setDestinationPlace(String destinationPlace) {
        this.destinationPlace = destinationPlace;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bid order = (Bid) o;
        return bidId == order.bidId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(bidId);
    }
}

