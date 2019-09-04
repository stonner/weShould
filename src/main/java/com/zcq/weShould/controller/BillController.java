package com.zcq.weShould.controller;

import com.zcq.weShould.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillService billService;

    @RequestMapping("/findAll")
    public Object findAll() {
        return billService.findAll();
    }
}
