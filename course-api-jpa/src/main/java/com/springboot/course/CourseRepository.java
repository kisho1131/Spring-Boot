package com.springboot.course;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

/* In the CrudRepository all the crud methods are already implemented as generic */
public interface CourseRepository extends CrudRepository<Course, String> {
    public List<Course> findByTopicId(String topicId);
}
