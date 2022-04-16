package com.springboot.topic;

import org.springframework.data.repository.CrudRepository;

/* In the CrudRepository all the crud methods are already implemented as generic */
public interface TopicRepository extends CrudRepository<Topic, String> {

    // getAllTopics() --> Return all the topics from the database

}
