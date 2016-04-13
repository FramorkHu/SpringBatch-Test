package com.springbatch.demo.writedb;

import com.springbatch.demo.model.User;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemWriter;

import javax.batch.api.chunk.listener.ChunkListener;
import java.io.BufferedWriter;
import java.io.File;
import java.util.List;

/**
 * Created by huyan on 2016/4/13.
 */
public class FileWriter implements ItemWriter<String> ,StepExecutionListener{

    private String filePath;
    private BufferedWriter writer = null;



    @Override
    public void write(List<? extends String> items) throws Exception {
        System.out.println(items.size());
        for (String user : items){
                writer.write(user+"\n");
        }
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {

        System.out.println("write before");
        File file = new File(filePath);
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            writer = new BufferedWriter(new java.io.FileWriter(file));
        } catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("write after");
        if (writer !=null){
            try {
                writer.flush();
                writer.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
