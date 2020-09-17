package com.example.service;

import com.example.entity.GraveSale;

import java.util.List;

public interface GraveSaleService {

    List<GraveSale> findByOperationNo(String operationNo);

}
