package com.zcq.weShould.service;

import com.zcq.weShould.annotation.SendMsg;
import com.zcq.weShould.entity.Bill;
import com.zcq.weShould.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BillService {
    @Autowired
    private BillRepository billRepository;

    @SendMsg
    public List<Bill> findAll() {
        System.out.println("000000000000000");
        return (List<Bill>) billRepository.findAll();
    }
}
