package com.springbatch.demo.writedb;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huyan on 2016/4/13.
 */
public class Run {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext c =
                new ClassPathXmlApplicationContext("write_db.xml");
        SimpleJobLauncher launcher = new SimpleJobLauncher();
        launcher.setJobRepository((JobRepository) c.getBean("jobRepository"));
        launcher.setTaskExecutor(new SimpleAsyncTaskExecutor());
        Map<String, JobParameter> parameterMap = new HashMap<>();
        JobParameter jobParameter = new JobParameter("aaa11111111");
        parameterMap.put("aa",jobParameter);
        try {
            launcher.run((Job) c.getBean("messageJob"), new JobParameters(parameterMap));
            /*Thread.sleep(10*1000);
            launcher.run((Job) c.getBean("messageJob"), new JobParameters(parameterMap));*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
