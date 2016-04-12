package com.springbatch.demo.operate;

import com.springbatch.demo.model.Message;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * Created by huyan on 2016/4/12.
 */
public class MessagesItemWriter implements ItemWriter<Message> {

    @Override
    public void write(List<? extends Message> list) throws Exception {
        System.out.println("write results");
        for (Message m : list) {
            System.out.println(m.getContent());
        }
    }
}
