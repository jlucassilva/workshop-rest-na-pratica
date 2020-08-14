package br.com.workshop.model.entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Order extends PanacheMongoEntity {

    private String client;
    private String product;
    private Integer amount;
    private BigDecimal value;
    private LocalDate dateCreation;
    private Boolean pending;

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Boolean getPending() {
        return pending;
    }

    public void setPending(Boolean pending) {
        this.pending = pending;
    }
}
