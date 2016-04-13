package com.springbatch.demo.operate;

import com.springbatch.demo.model.Message;
import com.springbatch.demo.model.User;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by huyan on 2016/4/12.
 */
public class MessagesItemProcessor implements ItemProcessor<User, User> {

    @Override
    public User process(User user) throws Exception {
        return user;
    }

}
