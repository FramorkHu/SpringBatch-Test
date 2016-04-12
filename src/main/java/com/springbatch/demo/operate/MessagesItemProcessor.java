package com.springbatch.demo.operate;

import com.springbatch.demo.model.Message;
import com.springbatch.demo.model.User;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by huyan on 2016/4/12.
 */
public class MessagesItemProcessor implements ItemProcessor<User, Message> {

    @Override
    public Message process(User user) throws Exception {
        Message m = new Message();
        m.setContent("Hello " + user.getName()
                + ",please pay promptly at the end of this month.");
        return m;
    }

}
