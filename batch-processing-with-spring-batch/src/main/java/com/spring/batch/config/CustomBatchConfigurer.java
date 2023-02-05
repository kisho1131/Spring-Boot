package com.spring.batch.config;

import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.context.annotation.Bean;

public class CustomBatchConfigurer {

  @Bean
  JobRepository customJobRepository() throws Exception {
    JobRepositoryFactoryBean factoryBean = new JobRepositoryFactoryBean();
    return factoryBean.getObject();
  }
}
