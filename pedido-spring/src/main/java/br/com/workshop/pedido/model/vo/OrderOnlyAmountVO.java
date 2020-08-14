package br.com.workshop.pedido.model.vo;

import java.io.Serializable;

public class OrderOnlyAmountVO implements Serializable {

    public Integer amount;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
