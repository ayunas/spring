package com.baeldung.school;

import org.springframework.data.repository.CrudRepository;

public interface iCourseRepo extends CrudRepository<Course, Integer> {
}
