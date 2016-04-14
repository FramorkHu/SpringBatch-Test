package com.springbatch.demo.operate;

import com.springbatch.demo.model.User;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * Created by huyan on 2016/4/12.
 */
public class UserMapper implements FieldSetMapper<User> {
    @Override
    public User mapFieldSet(FieldSet fieldSet) throws BindException {
        User u = new User();
        try {
            u.setName(fieldSet.readString(0));
            u.setAge(fieldSet.readInt(1));
        } catch (Exception e){
            System.out.println(fieldSet);
        }
        return u;

    }
}
