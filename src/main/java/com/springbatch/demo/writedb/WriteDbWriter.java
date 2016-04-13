package com.springbatch.demo.writedb;

import com.springbatch.demo.model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

/**
 * Created by huyan on 2016/4/13.
 */
public class WriteDbWriter{

    private static final String FILE_PATH = "D:\\home\\batch.txt";

    public static void main(String[] args) throws Exception{

        long start = System.currentTimeMillis();

        File file = new File(FILE_PATH);
        if (!file.exists()){
            file.createNewFile();
        }
        BufferedWriter out = new BufferedWriter(new FileWriter(file));

        int i=0;

        while (i < 1000000){
            StringBuffer buffer = new StringBuffer();
            buffer.append("user").append(i).append(",").append(i).append("\n");
            out.write(buffer.toString());
            i++;
        }
        out.flush();
        out.close();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
