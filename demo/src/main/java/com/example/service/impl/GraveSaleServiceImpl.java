package com.example.service.impl;

import com.example.entity.GraveSale;
import com.example.repository.GraveSaleRepository;
import com.example.service.GraveSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GraveSaleServiceImpl implements GraveSaleService {

    @Autowired
    private GraveSaleRepository graveSaleRepository;


    @Override
    public List<GraveSale> findByOperationNo(String operationNo) {
        return graveSaleRepository.findAllByOperationNo(operationNo);
    }
}
