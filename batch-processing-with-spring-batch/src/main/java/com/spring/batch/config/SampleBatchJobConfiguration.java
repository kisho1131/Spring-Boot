package com.spring.batch.config;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class SampleBatchJobConfiguration {

  private final JobRepository customJobRepository;
  private final PlatformTransactionManager transactionManager;

  @Bean(name = "sampleJob")
  public Job sampleJob() {
    return new JobBuilder("sampleJob")
            .repository(customJobRepository)
            .start(this.sampleStep())
            .build();
  }

  @Bean(name = "sampleJob2")
  public Job sampleJob2() {
    return new JobBuilder("sampleJob2")
            .repository(customJobRepository)
            .incrementer(new RunIdIncrementer())
            .start(this.sampleStep2())
            .build();
  }

  @Bean
  Step sampleStep2() {
    return new StepBuilder("sampleStep2")
            .tasklet(((stepContribution, chunkContext) -> {
              System.out.println("Tasklet Step Run !!");
              return RepeatStatus.FINISHED;
            }))
            .repository(customJobRepository)
            .transactionManager(transactionManager)
            .build();
  }

  @Bean
  Step sampleStep() {
    return new StepBuilder("sampleStep")
            .tasklet(((stepContribution, chunkContext) -> {
              System.out.println("Tasklet Step Run !!");
              return RepeatStatus.FINISHED;
            }))
            .repository(customJobRepository)
            .transactionManager(transactionManager)
            .build();
  }
}
