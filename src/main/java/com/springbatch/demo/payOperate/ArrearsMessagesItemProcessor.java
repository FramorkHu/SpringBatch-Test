package com.springbatch.demo.payOperate;

import com.springbatch.demo.model.Bill;
import com.springbatch.demo.model.Message;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by huyan on 2016/4/12.
 */
public class ArrearsMessagesItemProcessor implements ItemProcessor<Bill, Message> {
    @Override
    public Message process(Bill item) throws Exception {

        if (item.getPayStatus() == 0){
            Message message = new Message();
            message.setContent("您已欠费");
            return message;
        }
        return null;
    }
}
