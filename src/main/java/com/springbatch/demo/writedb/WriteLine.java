package com.springbatch.demo.writedb;

import org.springframework.batch.item.file.transform.LineAggregator;

/**
 * Created by huyan on 2016/4/14.
 */
public class WriteLine implements LineAggregator<String>{
    @Override
    public String aggregate(String item) {
        return item;
    }
}
