package com.clip.Dto;

import java.text.SimpleDateFormat;

import java.util.Date;

public class Transaction implements Comparable<Transaction> {

    private String transaction_id;
    private Integer user_id;
    private Date date;
    private String description;
    private Float amount;

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getAmount() {
        return amount;
    }

    public String toJsonString() {

        StringBuffer sb = new StringBuffer();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        sb.append("{");
        sb.append(" transaction_id: ");
        sb.append("\"" + transaction_id + "\"");
        sb.append(", user_id: ");
        sb.append(user_id);
        sb.append(", date: ");
        sb.append(sdf.format(date));
        sb.append(", description:");
        sb.append("\"" + description + "\"");
        sb.append(", amount:");
        sb.append(amount);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public int compareTo(Transaction trans) {
        if (getDate() == null || trans.getDate() == null)
            return 0;
        return getDate().compareTo(trans.getDate());
    }
}
