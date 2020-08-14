package br.com.workshop.model.entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.time.LocalDate;

public class Preparation extends PanacheMongoEntity {

    private String codOrder;
    private String employer;
    private Boolean pending;
    private LocalDate dateRegister;

    public String getCodOrder() {
        return codOrder;
    }

    public void setCodOrder(String codOrder) {
        this.codOrder = codOrder;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public Boolean getPending() {
        return pending;
    }

    public void setPending(Boolean pending) {
        this.pending = pending;
    }

    public LocalDate getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(LocalDate dateRegister) {
        this.dateRegister = dateRegister;
    }
}
