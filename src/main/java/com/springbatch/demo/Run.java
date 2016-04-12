package com.springbatch.demo;

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
 * Created by huyan on 2016/4/12.
 */
public class Run {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext c =
                new ClassPathXmlApplicationContext("billing_job.xml");
        SimpleJobLauncher launcher = new SimpleJobLauncher();
        launcher.setJobRepository((JobRepository) c.getBean("jobRepository"));
        launcher.setTaskExecutor(new SimpleAsyncTaskExecutor());
        Map<String,JobParameter> parameters = new HashMap<String,JobParameter>();
        parameters.put("month",new JobParameter("2011-10"));

        try {
            launcher.run((Job) c.getBean("billingJob"), new JobParameters(parameters));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
