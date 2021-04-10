package com.youtube.learncodedurgesh;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iAnswerRepo extends CrudRepository<Answer, Integer> {
}

