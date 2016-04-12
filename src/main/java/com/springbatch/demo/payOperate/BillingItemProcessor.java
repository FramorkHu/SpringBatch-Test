package com.springbatch.demo.payOperate;

import com.springbatch.demo.model.Bill;
import com.springbatch.demo.model.User;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by huyan on 2016/4/12.
 */
public class BillingItemProcessor implements ItemProcessor<User, Bill> {

    @Override
    public Bill process(User item) throws Exception {
        Bill bill = new Bill();
        bill.setUser(item);
        bill.setFees(70.0);
        bill.setPaidFees(0.0);
        bill.setUnpaidFees(70.0);
        bill.setPayStatus(0);
        return bill;
    }

}
