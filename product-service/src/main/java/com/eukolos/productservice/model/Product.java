package com.eukolos.productservice.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Document
public class Product {
    @MongoId
    private String id;

    private String name;
    private double price;
    private double amount;
    private List<String> oemList;
    @CreatedDate
    private Date createDate;
    @LastModifiedDate
    private Date updateDate;

    public Product() {
    }
    public Product(String name, double price, double amount, List<String> oemList) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.oemList = oemList;
    }

    public Product(String id, String name, double price, double amount, List<String> oemList, Date createDate, Date updateDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.oemList = oemList;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<String> getOemList() {
        return oemList;
    }

    public void setOemList(List<String> oemList) {
        this.oemList = oemList;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Double.compare(product.price, price) == 0 && Double.compare(product.amount, amount) == 0 && Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(oemList, product.oemList) && Objects.equals(createDate, product.createDate) && Objects.equals(updateDate, product.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, amount, oemList, createDate, updateDate);
    }
}
