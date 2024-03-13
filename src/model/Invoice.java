package model;

import java.math.BigDecimal;

public class Invoice {
    private String orderId;
    private BigDecimal totalAmount;
    private Buyer buyer;
    private Seller seller;
    private AdditionalMessages additionalMessages;

    public Invoice(String orderId, BigDecimal totalAmount, Buyer buyer, Seller seller, AdditionalMessages additionalMessages) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.buyer = buyer;
        this.seller = seller;
        this.additionalMessages = additionalMessages;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public AdditionalMessages getAdditionalMessages() {
        return additionalMessages;
    }

    public void setAdditionalMessages(AdditionalMessages additionalMessages) {
        this.additionalMessages = additionalMessages;
    }
}
