package com.neto.desafio.batch;

import com.neto.desafio.domain.report.Report;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

import static java.lang.String.valueOf;
import static java.lang.System.currentTimeMillis;

@Configuration
@EnableBatchProcessing
@EnableScheduling
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class BatchConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final JobLauncher jobLauncher;
    private JobExecution jobExecution;

    public BatchConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, JobLauncher jobLauncher) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.jobLauncher = jobLauncher;
    }

    @Scheduled(cron = "0/15 * * * * ?" )
    public void perform() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {

        JobParameters param = new JobParametersBuilder()
                .addString("JobID", valueOf(currentTimeMillis()))
                .toJobParameters();

        if (jobExecution == null || !jobExecution.isRunning()) {
            jobExecution = jobLauncher.run(job(), param);
        }

    }

    @Bean
    public FilteItemReader itemReader() {
        return new FilteItemReader();
    }

    @Bean
    public FileItemProcessor itemProcessor() {
        return new FileItemProcessor();
    }

    @Bean
    public FileItemWriter itemWriter() {
        return new FileItemWriter();
    }

    @Bean
    public Step step(){
        return stepBuilderFactory.get("step")
                .<List<String>, Report>chunk(1)
                .reader(itemReader())
                .processor(itemProcessor())
                .writer(itemWriter())
                .build();

    }

    @Bean
    public Job job() {
        return jobBuilderFactory.get("job")
                .incrementer(new RunIdIncrementer())
                .flow(step())
                .end()
                .build();

    }


}
