package com.springbatch.demo.payOperate;

import com.springbatch.demo.exception.MoneyNotEnoughException;
import com.springbatch.demo.model.Bill;
import com.springbatch.demo.model.PayRecord;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by huyan on 2016/4/12.
 */
public class PaymentItemProcessor implements ItemProcessor<Bill, PayRecord> {

    @Override
    public PayRecord process(Bill item) throws Exception {

        double balance = item.getUser().getBalance();

        if (balance<=0){
            return null;
        }

        if (balance>=item.getUnpaidFees()){
            PayRecord payRecord = new PayRecord();
            payRecord.setBill(item);
            payRecord.setPaidFees(item.getUnpaidFees());

            balance = balance- item.getUnpaidFees();
            item.getUser().setBalance(balance);

            item.setPaidFees(item.getUnpaidFees());
            item.setPayStatus(1);
            item.setUnpaidFees(0.0);

            return payRecord;

        } else {
            throw new MoneyNotEnoughException();
        }

    }
}
