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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
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
    @Column(name = "salePallets")
    private String salePallets;
    @Column(name = "comment")
    private String comment;
    @Column(name = "destinationPlace")
    @NotEmpty(message = "*Будь ласка вкажіть місце поставки")
    private String destinationPlace;
    @Column(name = "destinationCountry")
    @NotEmpty(message = "*Будь ласка вкажіть країну поставки")
    private String destinationCountry;
    @Column(name = "purchaseAdmixture")
    private Float purchaseAdmixture;
    @Column(name = "purchaseHumidity")
    private Float purchaseHumidity;
    @Column(name = "purchasePrice")
    private Integer purchasePrice;
    @Column(name = "purchasePackingType")
    private String purchasePackingType;
    @Column(name = "purchaseCurrency")
    private String purchaseCurrency;
    @Column(name = "purchasePallets")
    private String purchasePallets;
    @Column(name = "purchasePlace")
    private String purchasePlace;
    @Column(name = "purchaseCountry")
    private String purchaseCountry;
    @Column(name = "purchaseWeight")
    private Integer purchaseWeight;
    @Column(name = "purchaseDeliveryCosts")
    private Integer purchaseDeliveryCosts;
    @Column(name = "saleDeliveryCosts")
    private Integer saleDeliveryCosts;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
//    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "id", nullable = false)
//    private PurchaseData purchaseData;

    public Bid() {
    }

//    public PurchaseData getPurchaseData() {
//        return purchaseData;
//    }
//
//    public void setPurchaseData(PurchaseData purchaseData) {
//        this.purchaseData = purchaseData;
//    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSalePallets() {
        return salePallets;
    }

    public void setSalePallets(String salePallets) {
        this.salePallets = salePallets;
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

    public Integer getPurchaseDeliveryCosts() {
        return purchaseDeliveryCosts;
    }

    public void setPurchaseDeliveryCosts(Integer purchaseDeliveryCosts) {
        this.purchaseDeliveryCosts = purchaseDeliveryCosts;
    }

    public Integer getSaleDeliveryCosts() {
        return saleDeliveryCosts;
    }

    public void setSaleDeliveryCosts(Integer saleDeliveryCosts) {
        this.saleDeliveryCosts = saleDeliveryCosts;
    }

    public Float getPurchaseAdmixture() {
        return purchaseAdmixture;
    }

    public void setPurchaseAdmixture(Float purchaseAdmixture) {
        this.purchaseAdmixture = purchaseAdmixture;
    }

    public Float getPurchaseHumidity() {
        return purchaseHumidity;
    }

    public void setPurchaseHumidity(Float purchaseHumidity) {
        this.purchaseHumidity = purchaseHumidity;
    }

    public Integer getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Integer purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getPurchasePackingType() {
        return purchasePackingType;
    }

    public void setPurchasePackingType(String purchasePackingType) {
        this.purchasePackingType = purchasePackingType;
    }

    public String getPurchaseCurrency() {
        return purchaseCurrency;
    }

    public void setPurchaseCurrency(String purchaseCurrency) {
        this.purchaseCurrency = purchaseCurrency;
    }

    public String getPurchasePallets() {
        return purchasePallets;
    }

    public void setPurchasePallets(String purchasePallets) {
        this.purchasePallets = purchasePallets;
    }

    public String getPurchasePlace() {
        return purchasePlace;
    }

    public void setPurchasePlace(String purchasePlace) {
        this.purchasePlace = purchasePlace;
    }

    public String getPurchaseCountry() {
        return purchaseCountry;
    }

    public void setPurchaseCountry(String purchaseCountry) {
        this.purchaseCountry = purchaseCountry;
    }

    public Integer getPurchaseWeight() {
        return purchaseWeight;
    }

    public void setPurchaseWeight(Integer purchaseWeight) {
        this.purchaseWeight = purchaseWeight;
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
        return id == order.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}

