package com.springbatch.demo.writedb;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.io.*;

/**
 * Created by huyan on 2016/4/13.
 */
public class FileReader implements ItemReader<String>, StepExecutionListener {
    private String filePath;
    private BufferedReader bufferedReader = null;
    long start;
    long end;
    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        String line = bufferedReader.readLine();
        if ("".equals(line)){
            throw new RuntimeException();
        }
        return line;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("read start");
        start = System.currentTimeMillis();
        File filename = new File(filePath);
        try {
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename)); // 建立一个输入流对象reader
            bufferedReader = new BufferedReader(reader);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("after start");
        try {
            if (bufferedReader != null){
                bufferedReader.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        end = System.currentTimeMillis();
        System.out.println(end-start);
        return null;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
