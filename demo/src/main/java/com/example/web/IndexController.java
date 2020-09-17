package com.example.web;

import com.example.entity.GraveSale;
import com.example.entity.PaymentRecords;
import com.example.service.GraveSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IndexController {

    @Autowired
    GraveSaleService graveSaleService;

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/grave.html");
        return modelAndView;
    }

    @RequestMapping(value = "/search/{searchNo}",method = RequestMethod.GET)
    public GraveSale search(@PathVariable String searchNo) {
        List<GraveSale> list = graveSaleService.findByOperationNo(searchNo);
        if (null != list && list.size() > 0) {
            StringBuilder sb = new StringBuilder();
            List<PaymentRecords> paymentRecords = new ArrayList<>();
            for (GraveSale grave : list) {
                sb.append(grave.getGraveUser());
                sb.append(" ");
                if (null != grave.getPaymentRecords() && grave.getPaymentRecords().size() > 0) {
                    paymentRecords.addAll(grave.getPaymentRecords());
                }
            }
            GraveSale grave = list.get(0);
            grave.setGraveUser(sb.toString());
            grave.setPaymentRecords(paymentRecords);
            return grave;
        } else {
            return null;
        }
    }


}
