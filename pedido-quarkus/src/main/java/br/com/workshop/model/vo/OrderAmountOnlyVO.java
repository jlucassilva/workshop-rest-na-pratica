package br.com.workshop.model.vo;

import java.io.Serializable;

public class OrderAmountOnlyVO implements Serializable {
    public Integer amount;
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
