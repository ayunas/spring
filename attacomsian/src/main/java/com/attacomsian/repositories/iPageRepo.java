package com.attacomsian.repositories;

import com.attacomsian.entities.Book;
import com.attacomsian.entities.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface iPageRepo extends CrudRepository<Page, Long> {
	List<Page> findByBook(Book book, Sort sort);
}

