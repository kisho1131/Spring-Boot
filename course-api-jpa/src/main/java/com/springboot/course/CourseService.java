package com.springboot.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId){
        // return topics;
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }
    public Course getCourse(String id){
        // return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
        Optional<Course> courseResponse = courseRepository.findById(id);
        return courseResponse.get();
    }

    public void addCourse(Course course) {
        // topics.add(topic);
        courseRepository.save(course);
    }

    /* Function to update the Topic List with the given id */
    public void updateCourses(Course course) {
        /*
        for(int i =0;i<topics.size(); i++){
            Topic t = topics.get(i);
            if(t.getId().equals(id)){
                topics.set(i, topic);
                return;
            }
        }
         */
        courseRepository.save(course);
    }

    public void deleteCourses(String id) {
        // topics.removeIf(t-> t.getId().equals(id));
        courseRepository.deleteById(id);
    }
}
