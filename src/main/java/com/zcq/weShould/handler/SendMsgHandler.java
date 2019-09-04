package com.zcq.weShould.handler;

import com.google.common.eventbus.Subscribe;
import com.zcq.weShould.entity.Bill;
import org.springframework.stereotype.Component;

@Component
public class SendMsgHandler {

    @Subscribe
    public void sendMsg(Bill bill) {
        System.out.println("3333333333333333333");
        System.out.println("bill: "+bill.getUserName()+"  "+bill.getPassword()+"  "+bill.getId());
    }
}
