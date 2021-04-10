package com.baeldung.school;

import org.springframework.data.repository.CrudRepository;

public interface iStudentRepo extends CrudRepository<Student, Integer> {
}
