package com.springbatch.demo.writedb;

import com.springbatch.demo.model.User;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.util.NumberUtils;

/**
 * Created by huyan on 2016/4/14.
 */
public class ReadLine implements LineMapper<String> {
    @Override
    public String mapLine(String line, int lineNumber) throws Exception {



        try {
            String data[] = line.split(",");
            Integer.parseInt(data[1]);
            return line;
        } catch (Exception e){
            System.out.println(line);
        }
        return "";
    }

}
