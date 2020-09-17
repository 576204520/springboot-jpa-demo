package com.example.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "payment_records")
public class PaymentRecords implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 关联id
     */
    @Basic
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 创建时间
     */
    @Basic
    @Column(name = "create_date")
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String createDate;

    /**
     * 缴费金额
     */
    @Basic
    @Column(name = "price")
    private Double price;

    /**
     * 缴费期限
     */
    @Basic
    @Column(name = "tarm")
    private String tarm;

    /**
     * 到期时间
     */
    @Basic
    @Column(name = "end_date")
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String endDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTarm() {
        return tarm;
    }

    public void setTarm(String tarm) {
        this.tarm = tarm;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "PaymentRecords{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", createDate='" + createDate + '\'' +
                ", price=" + price +
                ", tarm='" + tarm + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
