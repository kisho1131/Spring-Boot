package com.spring.batch.batch;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
@AllArgsConstructor
public class PersonBatchJobConfiguration {

  private final PersonStepConfiguration personStepConfiguration;
  private final JobRepository jobRepository;
  private final JobCompletionNotificationListener listener;


  @Bean
  public Job importUserJob() {

    return new JobBuilder("importUserJob")
            .repository(jobRepository)
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(personStepConfiguration.step1())
            .end()
            .build();
  }
}
