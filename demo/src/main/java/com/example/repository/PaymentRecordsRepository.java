package com.example.repository;

import com.example.entity.GraveSale;
import com.example.entity.PaymentRecords;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;


public interface PaymentRecordsRepository extends JpaRepository<PaymentRecords, Long>, Serializable {

}
