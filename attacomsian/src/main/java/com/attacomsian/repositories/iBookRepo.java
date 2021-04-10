package com.attacomsian.repositories;

import com.attacomsian.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface iBookRepo extends CrudRepository<Book, Long> {
	Book findByIsbn(String isbn);  //public is not necessary because the intent of an interface is for it to be used by others, obviously necessitating it to be public
}


