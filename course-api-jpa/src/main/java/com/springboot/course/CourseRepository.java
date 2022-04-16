package com.springboot.course;

import org.springframework.data.repository.CrudRepository;

/* In the CrudRepository all the crud methods are already implemented as generic */
public interface CourseRepository extends CrudRepository<Course, String> {

    // getAllTopics() --> Return all the topics from the database

}
