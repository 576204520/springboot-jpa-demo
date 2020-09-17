package com.example.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "grave_sale")
public class GraveSale implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 业务编号
     */
    @Basic
    @Column(name = "operation_no")
    private String operationNo;

    /**
     * 墓穴位置
     */
    @Basic
    @Column(name = "grave_full_path")
    private String graveFullPath;

    /**
     * 业务编号
     */
    @Basic
    @Column(name = "contact_name")
    private String contactName;

    /**
     * 墓穴使用人
     */
    @Basic
    @Column(name = "grave_user")
    private String graveUser;

    /**
     * 墓穴使用人
     */
    @Basic
    @Column(name = "end_date")
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String endDate;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private List<PaymentRecords> paymentRecords;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperationNo() {
        return operationNo;
    }

    public void setOperationNo(String operationNo) {
        this.operationNo = operationNo;
    }

    public String getGraveFullPath() {
        return graveFullPath;
    }

    public void setGraveFullPath(String graveFullPath) {
        this.graveFullPath = graveFullPath;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getGraveUser() {
        return graveUser;
    }

    public void setGraveUser(String graveUser) {
        this.graveUser = graveUser;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<PaymentRecords> getPaymentRecords() {
        return paymentRecords;
    }

    public void setPaymentRecords(List<PaymentRecords> paymentRecords) {
        this.paymentRecords = paymentRecords;
    }

    @Override
    public String toString() {
        return "GraveSale{" +
                "id=" + id +
                ", operationNo='" + operationNo + '\'' +
                ", graveFullPath='" + graveFullPath + '\'' +
                ", contactName='" + contactName + '\'' +
                ", graveUser='" + graveUser + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
