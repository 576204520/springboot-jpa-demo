package com.example.repository;

import com.example.entity.GraveSale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;


public interface GraveSaleRepository extends JpaRepository<GraveSale, Long>, Serializable {
    List<GraveSale> findAllByOperationNo(String operationNo);
}
